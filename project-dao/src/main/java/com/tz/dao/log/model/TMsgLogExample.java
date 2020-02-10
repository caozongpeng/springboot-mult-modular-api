package com.tz.dao.log.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TMsgLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TMsgLogExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andMsgIdIsNull() {
            addCriterion("msg_id is null");
            return (Criteria) this;
        }

        public Criteria andMsgIdIsNotNull() {
            addCriterion("msg_id is not null");
            return (Criteria) this;
        }

        public Criteria andMsgIdEqualTo(String value) {
            addCriterion("msg_id =", value, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdNotEqualTo(String value) {
            addCriterion("msg_id <>", value, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdGreaterThan(String value) {
            addCriterion("msg_id >", value, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdGreaterThanOrEqualTo(String value) {
            addCriterion("msg_id >=", value, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdLessThan(String value) {
            addCriterion("msg_id <", value, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdLessThanOrEqualTo(String value) {
            addCriterion("msg_id <=", value, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdLike(String value) {
            addCriterion("msg_id like", value, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdNotLike(String value) {
            addCriterion("msg_id not like", value, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdIn(List<String> values) {
            addCriterion("msg_id in", values, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdNotIn(List<String> values) {
            addCriterion("msg_id not in", values, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdBetween(String value1, String value2) {
            addCriterion("msg_id between", value1, value2, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdNotBetween(String value1, String value2) {
            addCriterion("msg_id not between", value1, value2, "msgId");
            return (Criteria) this;
        }

        public Criteria andExchangeIsNull() {
            addCriterion("exchange is null");
            return (Criteria) this;
        }

        public Criteria andExchangeIsNotNull() {
            addCriterion("exchange is not null");
            return (Criteria) this;
        }

        public Criteria andExchangeEqualTo(String value) {
            addCriterion("exchange =", value, "exchange");
            return (Criteria) this;
        }

        public Criteria andExchangeNotEqualTo(String value) {
            addCriterion("exchange <>", value, "exchange");
            return (Criteria) this;
        }

        public Criteria andExchangeGreaterThan(String value) {
            addCriterion("exchange >", value, "exchange");
            return (Criteria) this;
        }

        public Criteria andExchangeGreaterThanOrEqualTo(String value) {
            addCriterion("exchange >=", value, "exchange");
            return (Criteria) this;
        }

        public Criteria andExchangeLessThan(String value) {
            addCriterion("exchange <", value, "exchange");
            return (Criteria) this;
        }

        public Criteria andExchangeLessThanOrEqualTo(String value) {
            addCriterion("exchange <=", value, "exchange");
            return (Criteria) this;
        }

        public Criteria andExchangeLike(String value) {
            addCriterion("exchange like", value, "exchange");
            return (Criteria) this;
        }

        public Criteria andExchangeNotLike(String value) {
            addCriterion("exchange not like", value, "exchange");
            return (Criteria) this;
        }

        public Criteria andExchangeIn(List<String> values) {
            addCriterion("exchange in", values, "exchange");
            return (Criteria) this;
        }

        public Criteria andExchangeNotIn(List<String> values) {
            addCriterion("exchange not in", values, "exchange");
            return (Criteria) this;
        }

        public Criteria andExchangeBetween(String value1, String value2) {
            addCriterion("exchange between", value1, value2, "exchange");
            return (Criteria) this;
        }

        public Criteria andExchangeNotBetween(String value1, String value2) {
            addCriterion("exchange not between", value1, value2, "exchange");
            return (Criteria) this;
        }

        public Criteria andRoutingKeyIsNull() {
            addCriterion("routing_key is null");
            return (Criteria) this;
        }

        public Criteria andRoutingKeyIsNotNull() {
            addCriterion("routing_key is not null");
            return (Criteria) this;
        }

        public Criteria andRoutingKeyEqualTo(String value) {
            addCriterion("routing_key =", value, "routingKey");
            return (Criteria) this;
        }

        public Criteria andRoutingKeyNotEqualTo(String value) {
            addCriterion("routing_key <>", value, "routingKey");
            return (Criteria) this;
        }

        public Criteria andRoutingKeyGreaterThan(String value) {
            addCriterion("routing_key >", value, "routingKey");
            return (Criteria) this;
        }

        public Criteria andRoutingKeyGreaterThanOrEqualTo(String value) {
            addCriterion("routing_key >=", value, "routingKey");
            return (Criteria) this;
        }

        public Criteria andRoutingKeyLessThan(String value) {
            addCriterion("routing_key <", value, "routingKey");
            return (Criteria) this;
        }

        public Criteria andRoutingKeyLessThanOrEqualTo(String value) {
            addCriterion("routing_key <=", value, "routingKey");
            return (Criteria) this;
        }

        public Criteria andRoutingKeyLike(String value) {
            addCriterion("routing_key like", value, "routingKey");
            return (Criteria) this;
        }

        public Criteria andRoutingKeyNotLike(String value) {
            addCriterion("routing_key not like", value, "routingKey");
            return (Criteria) this;
        }

        public Criteria andRoutingKeyIn(List<String> values) {
            addCriterion("routing_key in", values, "routingKey");
            return (Criteria) this;
        }

        public Criteria andRoutingKeyNotIn(List<String> values) {
            addCriterion("routing_key not in", values, "routingKey");
            return (Criteria) this;
        }

        public Criteria andRoutingKeyBetween(String value1, String value2) {
            addCriterion("routing_key between", value1, value2, "routingKey");
            return (Criteria) this;
        }

        public Criteria andRoutingKeyNotBetween(String value1, String value2) {
            addCriterion("routing_key not between", value1, value2, "routingKey");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andTryCountIsNull() {
            addCriterion("try_count is null");
            return (Criteria) this;
        }

        public Criteria andTryCountIsNotNull() {
            addCriterion("try_count is not null");
            return (Criteria) this;
        }

        public Criteria andTryCountEqualTo(Integer value) {
            addCriterion("try_count =", value, "tryCount");
            return (Criteria) this;
        }

        public Criteria andTryCountNotEqualTo(Integer value) {
            addCriterion("try_count <>", value, "tryCount");
            return (Criteria) this;
        }

        public Criteria andTryCountGreaterThan(Integer value) {
            addCriterion("try_count >", value, "tryCount");
            return (Criteria) this;
        }

        public Criteria andTryCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("try_count >=", value, "tryCount");
            return (Criteria) this;
        }

        public Criteria andTryCountLessThan(Integer value) {
            addCriterion("try_count <", value, "tryCount");
            return (Criteria) this;
        }

        public Criteria andTryCountLessThanOrEqualTo(Integer value) {
            addCriterion("try_count <=", value, "tryCount");
            return (Criteria) this;
        }

        public Criteria andTryCountIn(List<Integer> values) {
            addCriterion("try_count in", values, "tryCount");
            return (Criteria) this;
        }

        public Criteria andTryCountNotIn(List<Integer> values) {
            addCriterion("try_count not in", values, "tryCount");
            return (Criteria) this;
        }

        public Criteria andTryCountBetween(Integer value1, Integer value2) {
            addCriterion("try_count between", value1, value2, "tryCount");
            return (Criteria) this;
        }

        public Criteria andTryCountNotBetween(Integer value1, Integer value2) {
            addCriterion("try_count not between", value1, value2, "tryCount");
            return (Criteria) this;
        }

        public Criteria andNextTryTimeIsNull() {
            addCriterion("next_try_time is null");
            return (Criteria) this;
        }

        public Criteria andNextTryTimeIsNotNull() {
            addCriterion("next_try_time is not null");
            return (Criteria) this;
        }

        public Criteria andNextTryTimeEqualTo(Date value) {
            addCriterion("next_try_time =", value, "nextTryTime");
            return (Criteria) this;
        }

        public Criteria andNextTryTimeNotEqualTo(Date value) {
            addCriterion("next_try_time <>", value, "nextTryTime");
            return (Criteria) this;
        }

        public Criteria andNextTryTimeGreaterThan(Date value) {
            addCriterion("next_try_time >", value, "nextTryTime");
            return (Criteria) this;
        }

        public Criteria andNextTryTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("next_try_time >=", value, "nextTryTime");
            return (Criteria) this;
        }

        public Criteria andNextTryTimeLessThan(Date value) {
            addCriterion("next_try_time <", value, "nextTryTime");
            return (Criteria) this;
        }

        public Criteria andNextTryTimeLessThanOrEqualTo(Date value) {
            addCriterion("next_try_time <=", value, "nextTryTime");
            return (Criteria) this;
        }

        public Criteria andNextTryTimeIn(List<Date> values) {
            addCriterion("next_try_time in", values, "nextTryTime");
            return (Criteria) this;
        }

        public Criteria andNextTryTimeNotIn(List<Date> values) {
            addCriterion("next_try_time not in", values, "nextTryTime");
            return (Criteria) this;
        }

        public Criteria andNextTryTimeBetween(Date value1, Date value2) {
            addCriterion("next_try_time between", value1, value2, "nextTryTime");
            return (Criteria) this;
        }

        public Criteria andNextTryTimeNotBetween(Date value1, Date value2) {
            addCriterion("next_try_time not between", value1, value2, "nextTryTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}