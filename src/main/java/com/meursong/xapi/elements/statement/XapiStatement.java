package com.meursong.xapi.elements.statement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.meursong.xapi.elements.actor.XapiActor;
import com.meursong.xapi.elements.context.XapiContext;
import com.meursong.xapi.elements.object.XapiObject;
import com.meursong.xapi.elements.result.XapiResult;
import com.meursong.xapi.elements.verb.XapiVerb;
import com.meursong.xapi.util.XapiCommonUtil;

/**
 * 2024.12.24[susong]: LRS 설계
 * xAPI 규격의 Statements를 정의하는 클래스
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class XapiStatement {

    private XapiActor xapiActor;
    private XapiVerb xapiVerb;
    @JsonProperty("xapiObject")
    private XapiObject xapiObject;
    @JsonProperty("xapiContext")
    private XapiContext xapiContext;

    private XapiResult xapiResult;

    private String timestamp;
    private String id;

    public boolean validate() {
        return xapiActor.isValid()
                && xapiVerb.isValid()
                && xapiObject.isValid()
                && (xapiContext == null || xapiContext.isValid())
                && (xapiResult == null || xapiResult.isValid());
    }

    // Builder 패턴
    public static class XapiStatementBuilder {
        private XapiActor xapiActor;
        private XapiVerb xapiVerb;
        private XapiObject xapiObject;
        private XapiContext xapiContext;
        private XapiResult xapiResult;
        private String timestamp;
        private String id;

        public XapiStatementBuilder xapiActor(XapiActor xapiActor) {
            this.xapiActor = xapiActor;
            return this;
        }

        public XapiStatementBuilder xapiVerb(XapiVerb xapiVerb) {
            this.xapiVerb = xapiVerb;
            return this;
        }

        public XapiStatementBuilder xapiObject(XapiObject xapiObject) {
            this.xapiObject = xapiObject;
            return this;
        }

        public XapiStatementBuilder xapiContext(XapiContext xapiContext) {
            this.xapiContext = xapiContext;
            return this;
        }

        public XapiStatementBuilder xapiResult(XapiResult xapiResult) {
            this.xapiResult = xapiResult;
            return this;
        }

        public XapiStatementBuilder timestamp(String timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public XapiStatementBuilder id(String id) {
            this.id = id;
            return this;
        }

        public XapiStatement build() {
            XapiStatement statement = new XapiStatement();
            statement.xapiActor = this.xapiActor;
            statement.xapiVerb = this.xapiVerb;
            statement.xapiObject = this.xapiObject;
            statement.xapiContext = this.xapiContext;
            statement.xapiResult = this.xapiResult;
            statement.timestamp = this.timestamp;
            statement.id = this.id;
            return statement;
        }
    }

    public static XapiStatementBuilder builder() {
        return new XapiStatementBuilder().id(XapiCommonUtil.generateId());
    }
}
