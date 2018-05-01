package online.zhaopei.myproject.controller;

import com.github.pagehelper.PageHelper;
import online.zhaopei.myproject.domain.ArchiveRecord;
import online.zhaopei.myproject.domain.City;
import online.zhaopei.myproject.service.ArchiveRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArchiveRecordController {
    @Autowired
    private ArchiveRecordService archiveRecordService;

    @RequestMapping(value = "/archive/record", method = RequestMethod.GET)
    public List<ArchiveRecord> getArchivedRecord(@RequestParam(required=false) String refStart,
                                                 @RequestParam(required=false) String refEnd,
                                                 @RequestParam(required=false) String archiveNum,
                                                 @RequestParam(required=false) String owner,
                                                 @RequestParam(required=false) String user,
                                                 @RequestParam(required=false) String status,
                                                 @RequestParam(required=false) String returnStart,
                                                 @RequestParam(required=false) String returnEnd) {
        return this.archiveRecordService.findByCondition(refStart, refEnd, archiveNum, owner, user, status, returnStart, returnEnd);
    }
}
