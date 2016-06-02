package com.enity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/5/25.
 */
public class beaninfo_a {


    /**
     * status : 0
     * msg : ok
     * result : {"channel":"头条","num":"10","list":[{"title":"中国开闸放水27天解救越南旱灾","time":"2016-03-16 07:23","src":"中国网","category":"mil","pic":"http://api.jisuapi.com/news/upload/20160316/105123_31442.jpg","url":"http://mil.sina.cn/zgjq/2016-03-16/detail-ifxqhmve9235380.d.html?vt=4&pos=108","weburl":"http://mil.news.sina.com.cn/china/2016-03-16/doc-ifxqhmve9235380.shtml"}]}
     */

    private String status;
    private String msg;
    /**
     * channel : 头条
     * num : 10
     * list : [{"title":"中国开闸放水27天解救越南旱灾","time":"2016-03-16 07:23","src":"中国网","category":"mil","pic":"http://api.jisuapi.com/news/upload/20160316/105123_31442.jpg","url":"http://mil.sina.cn/zgjq/2016-03-16/detail-ifxqhmve9235380.d.html?vt=4&pos=108","weburl":"http://mil.news.sina.com.cn/china/2016-03-16/doc-ifxqhmve9235380.shtml"}]
     */

    private ResultBean result;

    public static beaninfo_a objectFromData(String str) {

        return new Gson().fromJson(str, beaninfo_a.class);
    }

    public static beaninfo_a objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), beaninfo_a.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<beaninfo_a> arraybeaninfo_aFromData(String str) {

        Type listType = new TypeToken<ArrayList<beaninfo_a>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<beaninfo_a> arraybeaninfo_aFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<beaninfo_a>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        private String channel;
        private String num;
        /**
         * title : 中国开闸放水27天解救越南旱灾
         * time : 2016-03-16 07:23
         * src : 中国网
         * category : mil
         * pic : http://api.jisuapi.com/news/upload/20160316/105123_31442.jpg
         * url : http://mil.sina.cn/zgjq/2016-03-16/detail-ifxqhmve9235380.d.html?vt=4&pos=108
         * weburl : http://mil.news.sina.com.cn/china/2016-03-16/doc-ifxqhmve9235380.shtml
         */

        private List<ListBean> list;

        public static ResultBean objectFromData(String str) {

            return new Gson().fromJson(str, ResultBean.class);
        }

        public static ResultBean objectFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);

                return new Gson().fromJson(jsonObject.getString(str), ResultBean.class);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        public static List<ResultBean> arrayResultBeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<ResultBean>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public static List<ResultBean> arrayResultBeanFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);
                Type listType = new TypeToken<ArrayList<ResultBean>>() {
                }.getType();

                return new Gson().fromJson(jsonObject.getString(str), listType);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            return new ArrayList();


        }

        public String getChannel() {
            return channel;
        }

        public void setChannel(String channel) {
            this.channel = channel;
        }

        public String getNum() {
            return num;
        }

        public void setNum(String num) {
            this.num = num;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            private String title;
            private String time;
            private String src;
            private String category;
            private String pic;
            private String url;
            private String weburl;

            public static ListBean objectFromData(String str) {

                return new Gson().fromJson(str, ListBean.class);
            }

            public static ListBean objectFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);

                    return new Gson().fromJson(jsonObject.getString(str), ListBean.class);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return null;
            }

            public static List<ListBean> arrayListBeanFromData(String str) {

                Type listType = new TypeToken<ArrayList<ListBean>>() {
                }.getType();

                return new Gson().fromJson(str, listType);
            }

            public static List<ListBean> arrayListBeanFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);
                    Type listType = new TypeToken<ArrayList<ListBean>>() {
                    }.getType();

                    return new Gson().fromJson(jsonObject.getString(str), listType);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return new ArrayList();


            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public String getSrc() {
                return src;
            }

            public void setSrc(String src) {
                this.src = src;
            }

            public String getCategory() {
                return category;
            }

            public void setCategory(String category) {
                this.category = category;
            }

            public String getPic() {
                return pic;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getWeburl() {
                return weburl;
            }

            public void setWeburl(String weburl) {
                this.weburl = weburl;
            }
        }
    }
}
