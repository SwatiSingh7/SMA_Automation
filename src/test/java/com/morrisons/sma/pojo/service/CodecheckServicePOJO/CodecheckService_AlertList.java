package com.morrisons.sma.pojo.service.CodecheckServicePOJO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CodecheckService_AlertList {
	
	@JsonProperty("markdownAlertRule")
	private Codecheck_MarkdownAlertRule markdownAlertRule;
	
//	@JsonProperty("deptAlertConstraint")
//	private Codecheck_DeptAlertConstraint deptAlertConstraint;

	public Codecheck_MarkdownAlertRule getMarkdownAlertRule() {
		return markdownAlertRule;
	}

	public void setMarkdownAlertRule(Codecheck_MarkdownAlertRule markdownAlertRule) {
		this.markdownAlertRule = markdownAlertRule;
	}

	@Override
	public String toString() {
		return "CodecheckService_AlertList [markdownAlertRule=" + markdownAlertRule + "]";
	}
	
	

//	public Codecheck_DeptAlertConstraint getDeptAlertConstraint() {
//		return deptAlertConstraint;
//	}
//
//	public void setDeptAlertConstraint(Codecheck_DeptAlertConstraint deptAlertConstraint) {
//		this.deptAlertConstraint = deptAlertConstraint;
//	}
//
//	@Override
//	public String toString() {
//		return "CodecheckService_AlertList [markdownAlertRule=" + markdownAlertRule + ", deptAlertConstraint="
//				+ deptAlertConstraint + "]";
//	}

	
	
	
	
//		@JsonProperty("markdownAlertRule")
//		private List<Codecheck_MarkdownAlertRule> markdownAlertRule;
//		
//		@JsonProperty("deptAlertConstraint")
//		private List<Codecheck_DeptAlertConstraint> deptAlertConstraint;
//
//		public List<Codecheck_MarkdownAlertRule> getMarkdownAlertRule() {
//			return markdownAlertRule;
//		}
//
//		public void setMarkdownAlertRule(List<Codecheck_MarkdownAlertRule> markdownAlertRule) {
//			this.markdownAlertRule = markdownAlertRule;
//		}
//
//		public List<Codecheck_DeptAlertConstraint> getDeptAlertConstraint() {
//			return deptAlertConstraint;
//		}
//
//		public void setDeptAlertConstraint(List<Codecheck_DeptAlertConstraint> deptAlertConstraint) {
//			this.deptAlertConstraint = deptAlertConstraint;
//		}
//
//		@Override
//		public String toString() {
//			return "CodecheckService_AlertList [markdownAlertRule=" + markdownAlertRule + ", deptAlertConstraint="
//					+ deptAlertConstraint + "]";
//		}
		
		
}
