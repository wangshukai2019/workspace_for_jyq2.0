package com.jyq.note.https.responses;

public class LoginRet extends BaseRet {

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private String accessToken;
        private String userKey;

        public String getAccessToken() {
            return accessToken;
        }

        public void setAccessToken(String accessToken) {
            this.accessToken = accessToken;
        }

        public String getUserKey() {
            return userKey;
        }

        public void setUserKey(String userKey) {
            this.userKey = userKey;
        }

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("DataBean{");
            sb.append("accessToken='").append(accessToken).append('\'');
            sb.append(", userKey='").append(userKey).append('\'');
            sb.append('}');
            return sb.toString();
        }
    }


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("LoginRet{");
        sb.append("data=").append(data);
        sb.append(", code=").append(code);
        sb.append(", msg='").append(msg).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
