package online.zhaopei.myproject.controller;

import com.github.pagehelper.PageHelper;
import online.zhaopei.myproject.domain.ArchiveRecord;
import online.zhaopei.myproject.domain.City;
import online.zhaopei.myproject.dtos.ArchiveQuery;
import online.zhaopei.myproject.service.ArchiveRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArchiveRecordController {
    @Autowired
    private ArchiveRecordService archiveRecordService;

    @RequestMapping(value = "/archive/records", method = RequestMethod.POST )
    @CrossOrigin
    public List<ArchiveRecord> getArchivedRecord(@RequestBody ArchiveQuery query) {
        return this.archiveRecordService.findByCondition(query.getRefStart(), query.getRefEnd(), query.getArchiveNum(),
                query.getOwner(), query.getUser(), query.getStatus(), query.getReturnStart(), query.getReturnEnd());
    }

    @RequestMapping(value = "/archive/record", method = RequestMethod.POST)
    public String addArchiveRecord(@RequestBody ArchiveRecord record) {
        archiveRecordService.add(record);
        return "ok";
    }

    @RequestMapping(value = "/archive/updaterecord", method = RequestMethod.POST)
    @CrossOrigin
    public String updateArchiveRecord(@RequestBody ArchiveRecord record) {
        archiveRecordService.update(record);
        return "ok";
    }
}
