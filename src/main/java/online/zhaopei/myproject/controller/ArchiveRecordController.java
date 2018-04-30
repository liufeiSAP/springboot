package online.zhaopei.myproject.controller;

import com.github.pagehelper.PageHelper;
import online.zhaopei.myproject.domain.ArchiveRecord;
import online.zhaopei.myproject.domain.City;
import online.zhaopei.myproject.service.ArchiveRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArchiveRecordController {
    @Autowired
    private ArchiveRecordService archiveRecordService;

    @RequestMapping("/archive/record")
    public List<ArchiveRecord> getArchivedRecord() {
        PageHelper.startPage(1, 3);
        return this.archiveRecordService.findByState("CA");
    }
}
