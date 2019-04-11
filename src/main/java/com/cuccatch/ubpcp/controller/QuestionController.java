package com.cuccatch.ubpcp.controller;
import com.cuccatch.ubpcp.dataobject.ChartDO;
import com.cuccatch.ubpcp.error.BusinessException;
import com.cuccatch.ubpcp.response.CommonReturnType;
import com.cuccatch.ubpcp.response.EmReturnStatusCode;
import com.cuccatch.ubpcp.service.AnswerService;
import com.cuccatch.ubpcp.service.ChartService;
import com.cuccatch.ubpcp.service.TokenService;
import com.cuccatch.ubpcp.service.UserService;
import com.cuccatch.ubpcp.service.model.AnswerModel;
import com.cuccatch.ubpcp.service.model.ChartModel;
import com.cuccatch.ubpcp.service.model.QuestionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController extends BaseController{
    @Autowired
    ChartService chartService;

    @Autowired
    TokenService tokenService;

    @Autowired
    UserService userService;
    @Autowired
    AnswerService answerService;


    @GetMapping("/saveChart")
    public CommonReturnType saveQuestion(@RequestParam String title,@RequestParam String direction, @RequestParam String uname, @RequestBody List<QuestionModel> questionModelList) throws BusinessException {
        ChartModel chartModel = new ChartModel();
        chartModel.setCreateUserId(userService.getUserByUsername(uname).getId());
        chartModel.setDirection(direction);
        chartModel.setTitle(title);
        chartService.saveChart(chartModel,questionModelList);
        return CommonReturnType.createPlainText("success", EmReturnStatusCode.COMMON_SUCCESS);
    }

    // 仅仅返回问卷摘要信息  具体问题不返回
    // 暂定一页10个
    @GetMapping("/getCharts")
    public CommonReturnType getCharts(@RequestParam Integer page) throws BusinessException {
        Page<ChartDO> chartDOS = chartService.getChartByPage(page, 10);
        return CommonReturnType.createSuccess(chartDOS.getContent(),"success");
    }

    @GetMapping("/getAllCharts")
    public CommonReturnType getAllCharts() throws BusinessException {
        List<ChartDO> chartDOList = chartService.getAllChart();
        return CommonReturnType.createSuccess(chartDOList,"success");
    }
    /**
     * Integer chartID;
     * Integer UID;
     * Integer QID;
     * String description;
     * String options;
     * @return CommonReturnType
     */
    @PostMapping("/saveAnswer")
    public CommonReturnType saveAnswer(@RequestBody AnswerModel answerModel) throws BusinessException {
        answerService.saveAnswer(answerModel);
        return CommonReturnType.createPlainText("success",EmReturnStatusCode.COMMON_SUCCESS);
    }
    @GetMapping("/getAnswer/{uid}")
    public CommonReturnType getAnswers(@PathVariable Integer uid) throws BusinessException {
        return CommonReturnType.createSuccess(answerService.getAnswersByUID(uid),"success");
    }
    @GetMapping("/getAnswerByChart/{chartId}")
    public CommonReturnType getAnswersByChart(@PathVariable Integer chartId) throws BusinessException {
        return CommonReturnType.createSuccess(answerService.getAnswersByChartID(chartId),"success");
    }
    @PostMapping("/saveAnswers")
    public CommonReturnType saveAnswers(@RequestBody List<AnswerModel> answerModels) throws BusinessException {
        answerService.saveAnswers(answerModels);
        return CommonReturnType.createPlainText("success",EmReturnStatusCode.COMMON_SUCCESS);
    }
    @GetMapping("/getQuestions/{chartId}")
    public CommonReturnType getQuestions(@PathVariable Integer chartId) throws BusinessException {
        List<QuestionModel> questionModelList = chartService.getQuestionsByChartId(chartId);
        return CommonReturnType.createSuccess(questionModelList,"success");
    }
}
