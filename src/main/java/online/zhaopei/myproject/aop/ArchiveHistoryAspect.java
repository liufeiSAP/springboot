package online.zhaopei.myproject.aop;

import online.zhaopei.myproject.domain.ArchiveRecord;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


@Component
@Aspect
public class ArchiveHistoryAspect {
    @After(("execution(* online.zhaopei.myproject.controller..*.*(..)) && @annotation(archiveHistory)"))
    public void doAfterAdvice(JoinPoint joinPoint, ArchiveHistory archiveHistory) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Object[] arg = joinPoint.getArgs();
        if (arg != null) {
            ArchiveRecord record = (ArchiveRecord)arg[0];
        }
    }
}
