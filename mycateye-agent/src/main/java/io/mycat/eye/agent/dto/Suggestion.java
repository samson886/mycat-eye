/**
 * All rights Reserved, Designed By www.openwork.org.cn
 * @Title:  Suggestion.java
 * @Package cn.bqjr.dbeye.agent.dto
 * @Description:    TODO
 * @author: 李平(360841519@qq.com)
 * @date:   2017年5月11日 上午11:39:06
 * @version V1.0
 * @Copyright: 2017 www.openwork.org.cn Inc. All rights reserved.
 */
package io.mycat.eye.agent.dto;


/**
 * @ClassName:  Suggestion
 * @Description:建议
 * @author: 李平(360841519@qq.com)
 * @date:   2017年5月11日 上午11:39:06
 *
 * @Copyright: 2017 www.openwork.org.cn Inc. All rights reserved.
 */
public class Suggestion {
    //问题
    private String problem;

    //建议
    private String suggestion;

    //现状
    private String current_status;

    //变量/公式
    private String variable;

    //验证标准
    private String standards;

    /**
     * @return the problem
     */
    public String getProblem() {
        return problem;
    }

    /**
     * @param problem the problem to set
     */
    public void setProblem(String problem) {
        this.problem = problem;
    }

    /**
     * @return the suggestion
     */
    public String getSuggestion() {
        return suggestion;
    }

    /**
     * @param suggestion the suggestion to set
     */
    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion;
    }

    /**
     * @return the current_status
     */
    public String getCurrent_status() {
        return current_status;
    }

    /**
     * @param current_status the current_status to set
     */
    public void setCurrent_status(String current_status) {
        this.current_status = current_status;
    }

    /**
     * @return the variable
     */
    public String getVariable() {
        return variable;
    }

    /**
     * @param variable the variable to set
     */
    public void setVariable(String variable) {
        this.variable = variable;
    }

    /**
     * @return the standards
     */
    public String getStandards() {
        return standards;
    }

    /**
     * @param standards the standards to set
     */
    public void setStandards(String standards) {
        this.standards = standards;
    }
}
