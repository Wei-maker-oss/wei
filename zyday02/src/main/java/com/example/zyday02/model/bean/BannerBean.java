package com.example.zyday02.model.bean;

import java.util.List;

public class BannerBean {

    /**
     * message : 请求i成功
     * code : 200
     * bannerlist : [{"imageurl":"https://yanxuan.nosdn.127.net/14939496197300723.jpg","htmlurl":"http://www.baidu.com"},{"imageurl":"https://yanxuan.nosdn.127.net/14931121822100127.jpg","htmlurl":"http://www.baidu.com"},{"imageurl":"https://yanxuan.nosdn.127.net/14931970965550315.jpg","htmlurl":"http://www.baidu.com"},{"imageurl":"https://yanxuan.nosdn.127.net/14932840600970609.jpg","htmlurl":"http://www.baidu.com"},{"imageurl":"https://yanxuan.nosdn.127.net/14937214454750141.jpg","htmlurl":"http://www.baidu.com"}]
     */

    //@com.fasterxml.jackson.annotation.JsonProperty("message")
    private String message;
    //@com.fasterxml.jackson.annotation.JsonProperty("code")
    private String code;
    /**
     * imageurl : https://yanxuan.nosdn.127.net/14939496197300723.jpg
     * htmlurl : http://www.baidu.com
     */

   // @com.fasterxml.jackson.annotation.JsonProperty("bannerlist")
    private List<BannerlistDTO> bannerlist;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<BannerlistDTO> getBannerlist() {
        return bannerlist;
    }

    public void setBannerlist(List<BannerlistDTO> bannerlist) {
        this.bannerlist = bannerlist;
    }

    public static class BannerlistDTO {
       // @com.fasterxml.jackson.annotation.JsonProperty("imageurl")
        private String imageurl;
       // @com.fasterxml.jackson.annotation.JsonProperty("htmlurl")
        private String htmlurl;

        public String getImageurl() {
            return imageurl;
        }

        public void setImageurl(String imageurl) {
            this.imageurl = imageurl;
        }

        public String getHtmlurl() {
            return htmlurl;
        }

        public void setHtmlurl(String htmlurl) {
            this.htmlurl = htmlurl;
        }
    }
}
