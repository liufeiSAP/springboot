package online.zhaopei.myproject.aop;

import online.zhaopei.myproject.domain.ArchiveRecord;
import online.zhaopei.myproject.domain.ArchiveRecordHistory;
import online.zhaopei.myproject.service.ArchiveRecordHistoryService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Component
@Aspect
public class ArchiveHistoryAspect {

    @Autowired
    private ArchiveRecordHistoryService archiveRecordHistoryService;

    @After(("execution(* online.zhaopei.myproject.controller..*.*(..)) && @annotation(archiveHistory)"))
    public void doAfterAdvice(JoinPoint joinPoint, ArchiveHistory archiveHistory) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Object[] arg = joinPoint.getArgs();
        if (arg != null) {
            ArchiveRecord record = (ArchiveRecord)arg[0];
            ArchiveRecordHistory his = new ArchiveRecordHistory();
            his.setArchiveNum(record.getArchiveNum());
            his.setId(record.getId());
            his.setOwner(record.getOwner());
            his.setReferdate(record.getReferdate());
            his.setReturndate(record.getReturndate());
            his.setStatus(record.getStatus());
            his.setUser(record.getUser());
            archiveRecordHistoryService.add(his);
        }
    }
}
