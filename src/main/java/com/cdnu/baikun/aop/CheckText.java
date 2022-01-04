package com.cdnu.baikun.aop;

import com.cdnu.baikun.domain.Comment;
import com.cdnu.baikun.domain.News;
import com.cdnu.baikun.domain.Resources;
import com.cdnu.baikun.dto.ResultVO;
import com.cdnu.baikun.utils.AipContentCensor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.util.Arrays;

/**
 * 对用户发表的资源和资讯进行文本审核
 * @author 白坤
 * @date 2021/8/16
 */
@Aspect
@Component
public class CheckText {

    /**
     * 对新闻和资源的文本审核
     */
    @Pointcut("execution( * com.cdnu.baikun.controller.user.ContributeController.add*(..))")
    public void checkcontribute() {
    }

    @Pointcut("execution( * com.cdnu.baikun.controller.api.user.*.update(..))")
    public void checkupdate() {
    }

    /*@Around("checkcontribute()||checkupdate()")
    public ResultVO checkText(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object[] args = proceedingJoinPoint.getArgs();
        for (Object obj : args) {
            if (obj instanceof News) {
                JSONObject res = AipContentCensor.checkText(((News) obj).getNewsTitle() + ((News) obj).getNewsContent());
                if (res.get("conclusion").equals("不合规")) {
                    JSONArray data = res.getJSONArray("data");
                    System.out.println(data);
                    return new ResultVO(res.get("conclusion").toString(), 1, data.toString());
                }
            } else if (obj instanceof Resources) {
                JSONObject res = AipContentCensor.checkText(((Resources) obj).getResourcesTitle() + ((Resources) obj).getResourcesContent());
                if (res.get("conclusion").equals("不合规")) {
                    JSONArray data = res.getJSONArray("data");
                    System.out.println(data);
                    return new ResultVO(res.get("conclusion").toString(), 1, data.toString());
                }
            }
        }
        Object o = proceedingJoinPoint.proceed();
        return (ResultVO) o;
    }*/

    /**
     * 对评论的文本审核
     */
    @Pointcut("execution( * com.cdnu.baikun.controller.api.user.CommentDataApi.add*Comment(..))")
    public void Check() {
    }

    @Around("Check()")
    public ResultVO checkCommentText(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object[] args = proceedingJoinPoint.getArgs();
        for (Object obj : args) {
            if (obj instanceof Comment) {
                JSONObject res = AipContentCensor.checkText(((Comment) obj).getCommentContent());
                if (res.get("conclusion").equals("不合规")) {
                    JSONArray data = res.getJSONArray("data");
                    System.out.println(data);
                    return new ResultVO(res.get("conclusion").toString(), 1, data.toString());
                }
            }
        }
        Object o = proceedingJoinPoint.proceed();
        return (ResultVO) o;
    }
}


