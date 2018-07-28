package online.zhaopei.myproject.controller;

import com.github.pagehelper.PageHelper;
import online.zhaopei.myproject.aop.ArchiveHistory;
import online.zhaopei.myproject.domain.ArchiveRecord;
import online.zhaopei.myproject.domain.City;
import online.zhaopei.myproject.dtos.ArchiveQuery;
import online.zhaopei.myproject.dtos.ResponseJson;
import online.zhaopei.myproject.service.ArchiveRecordService;
import online.zhaopei.myproject.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArchiveRecordController {

    @Autowired
    private MailService mailService;
    @Autowired
    private ArchiveRecordService archiveRecordService;

    @RequestMapping(value = "/archive/records", method = RequestMethod.POST )
    @CrossOrigin
    public List<ArchiveRecord> getArchivedRecord(@RequestBody ArchiveQuery query) {
        return this.archiveRecordService.findByCondition(query.getRefStart(), query.getRefEnd(), query.getArchiveNum(),
                query.getOwner(), query.getUser(), query.getStatus(), query.getReturnStart(), query.getReturnEnd());
    }

    @RequestMapping(value = "/archive/record", method = RequestMethod.POST)
    @CrossOrigin
    @ArchiveHistory("增加调档记录")
    public ResponseEntity<ResponseJson> addArchiveRecord(@RequestBody ArchiveRecord record) {
        try {
            archiveRecordService.add(record);
            mailService.sendMail(record);
            ResponseJson response = new ResponseJson();
            response.setStatus("1");
            response.setMessage("success");
            return new ResponseEntity<ResponseJson>(response, HttpStatus.OK );
        } catch (Exception e) {
            ResponseJson response = new ResponseJson();
            response.setStatus("0");
            response.setMessage("失败");
            return new ResponseEntity<ResponseJson>(response, HttpStatus.valueOf(500));
        }
    }

    @RequestMapping(value = "/archive/updaterecord", method = RequestMethod.POST)
    @CrossOrigin
    @ArchiveHistory(value = "更改调档记录")
    public String updateArchiveRecord(@RequestBody ArchiveRecord record) {
        archiveRecordService.update(record);
        return "ok";
    }
}
