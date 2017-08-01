package com.example.administrator.pandatv.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by li on 2017/7/30.
 */

public class PandaLiveOtherFragentBean {


    /**
     * video : [{"em":"CM01","img":"http://p5.img.cctvpic.com/fmspic/2017/02/10/83fa86f6848c44dabfba29220fb904a6-99.jpg","len":"00:02:58","order":"60","ptime":"2017-02-10 12:02:45","t":"《77滚滚秀》 20170210 第六十期：开年散步趴！","url":"http://tv.cntv.cn/video/VSET100272959126/83fa86f6848c44dabfba29220fb904a6","vid":"83fa86f6848c44dabfba29220fb904a6","vsid":"VSET100272959126"},{"em":"CM01","img":"http://p2.img.cctvpic.com/fmspic/2017/02/06/b26695e9e0014340a7d3f5dd16fc2b94-83.jpg","len":"00:02:27","order":"59","ptime":"2017-02-06 12:11:09","t":"《77滚滚秀》 20170206 第五十九期：快来许个新年愿望","url":"http://tv.cntv.cn/video/VSET100272959126/b26695e9e0014340a7d3f5dd16fc2b94","vid":"b26695e9e0014340a7d3f5dd16fc2b94","vsid":"VSET100272959126"},{"em":"CM01","img":"http://p1.img.cctvpic.com/fmspic/2017/01/20/a522c6b12e1d4385b535311f2f8f4874-83.jpg","len":"00:02:26","order":"58","ptime":"2017-01-20 16:54:39","t":"《77滚滚秀》 20170120 第五十八期：全球特工团子拜年大行动！","url":"http://tv.cntv.cn/video/VSET100272959126/a522c6b12e1d4385b535311f2f8f4874","vid":"a522c6b12e1d4385b535311f2f8f4874","vsid":"VSET100272959126"},{"em":"CM01","img":"http://p1.img.cctvpic.com/fmspic/2017/01/06/1edbf8d65a64480eab6f429f8447a30b-129.jpg","len":"00:04:40","order":"57","ptime":"2017-01-06 17:42:53","t":"《77滚滚秀》 20170106 第五十七期：经典\u201c神曲\u201d一首首","url":"http://tv.cntv.cn/video/VSET100272959126/1edbf8d65a64480eab6f429f8447a30b","vid":"1edbf8d65a64480eab6f429f8447a30b","vsid":"VSET100272959126"},{"em":"CM01","img":"http://p4.img.cctvpic.com/fmspic/2016/12/30/cbdb2112d41d417c9b5f3d19850b662a-129.jpg","len":"00:04:04","order":"56","ptime":"2016-12-30 16:34:29","t":"《77滚滚秀》 20161230 第五十六期：感谢2016  2017更精彩","url":"http://tv.cntv.cn/video/VSET100272959126/cbdb2112d41d417c9b5f3d19850b662a","vid":"cbdb2112d41d417c9b5f3d19850b662a","vsid":"VSET100272959126"},{"em":"CM01","img":"http://p2.img.cctvpic.com/fmspic/2016/12/25/47638ee728b04a848b8f8cb5470b4427-129.jpg","len":"00:03:46","order":"55","ptime":"2016-12-25 08:56:12","t":"《77滚滚秀》 20161224 第五十五期：圣诞节看节目收礼物咯！","url":"http://tv.cntv.cn/video/VSET100272959126/47638ee728b04a848b8f8cb5470b4427","vid":"47638ee728b04a848b8f8cb5470b4427","vsid":"VSET100272959126"},{"em":"CM01","img":"http://p5.img.cctvpic.com/fmspic/2016/12/16/74a810eebf1342a196b785410407cc4d-129.jpg","len":"00:03:44","order":"54","ptime":"2016-12-16 18:58:32","t":"《77滚滚秀》 20161216 第五十四期：胡来的左手","url":"http://tv.cntv.cn/video/VSET100272959126/74a810eebf1342a196b785410407cc4d","vid":"74a810eebf1342a196b785410407cc4d","vsid":"VSET100272959126"}]
     * videoset : {"0":{"bj":"","cd":"","desc":"《77滚滚秀》是一档集合所有滚滚精彩瞬间的娱乐、搞笑类节目，在这里你可以看到滚滚们搞笑、尴尬、萌萌哒，以及前所未见的所有神\u201c技能\u201d，每周五准时更新，还有更多互动和奖品等着你，快来加入我们吧。","dy":"","enname":"","fcl":"","fl":"","img":"http://p1.img.cctvpic.com/photoAlbum/vms/standard/img/2016/7/4/VSETBr7Ufabb0BvOFDWAzU1Z160704.jpg","js":"","name":"77滚滚秀","nf":"","playdesc":"","relvsid":"","sbpd":"","sbsj":"","url":"http://tv.cntv.cn/videoset/VSET100272959126","vsid":"VSET100272959126","yz":"","zcr":"","zy":""},"count":"70"}
     */

    private VideosetBean videoset;
    private List<VideoBean> video;

    public VideosetBean getVideoset() {
        return videoset;
    }

    public void setVideoset(VideosetBean videoset) {
        this.videoset = videoset;
    }

    public List<VideoBean> getVideo() {
        return video;
    }

    public void setVideo(List<VideoBean> video) {
        this.video = video;
    }

    public static class VideosetBean {
        /**
         * 0 : {"bj":"","cd":"","desc":"《77滚滚秀》是一档集合所有滚滚精彩瞬间的娱乐、搞笑类节目，在这里你可以看到滚滚们搞笑、尴尬、萌萌哒，以及前所未见的所有神\u201c技能\u201d，每周五准时更新，还有更多互动和奖品等着你，快来加入我们吧。","dy":"","enname":"","fcl":"","fl":"","img":"http://p1.img.cctvpic.com/photoAlbum/vms/standard/img/2016/7/4/VSETBr7Ufabb0BvOFDWAzU1Z160704.jpg","js":"","name":"77滚滚秀","nf":"","playdesc":"","relvsid":"","sbpd":"","sbsj":"","url":"http://tv.cntv.cn/videoset/VSET100272959126","vsid":"VSET100272959126","yz":"","zcr":"","zy":""}
         * count : 70
         */

        @SerializedName("0")
        private _$0Bean _$0;
        private String count;

        public _$0Bean get_$0() {
            return _$0;
        }

        public void set_$0(_$0Bean _$0) {
            this._$0 = _$0;
        }

        public String getCount() {
            return count;
        }

        public void setCount(String count) {
            this.count = count;
        }

        public static class _$0Bean {
            /**
             * bj :
             * cd :
             * desc : 《77滚滚秀》是一档集合所有滚滚精彩瞬间的娱乐、搞笑类节目，在这里你可以看到滚滚们搞笑、尴尬、萌萌哒，以及前所未见的所有神“技能”，每周五准时更新，还有更多互动和奖品等着你，快来加入我们吧。
             * dy :
             * enname :
             * fcl :
             * fl :
             * img : http://p1.img.cctvpic.com/photoAlbum/vms/standard/img/2016/7/4/VSETBr7Ufabb0BvOFDWAzU1Z160704.jpg
             * js :
             * name : 77滚滚秀
             * nf :
             * playdesc :
             * relvsid :
             * sbpd :
             * sbsj :
             * url : http://tv.cntv.cn/videoset/VSET100272959126
             * vsid : VSET100272959126
             * yz :
             * zcr :
             * zy :
             */

            private String bj;
            private String cd;
            private String desc;
            private String dy;
            private String enname;
            private String fcl;
            private String fl;
            private String img;
            private String js;
            private String name;
            private String nf;
            private String playdesc;
            private String relvsid;
            private String sbpd;
            private String sbsj;
            private String url;
            private String vsid;
            private String yz;
            private String zcr;
            private String zy;

            public String getBj() {
                return bj;
            }

            public void setBj(String bj) {
                this.bj = bj;
            }

            public String getCd() {
                return cd;
            }

            public void setCd(String cd) {
                this.cd = cd;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getDy() {
                return dy;
            }

            public void setDy(String dy) {
                this.dy = dy;
            }

            public String getEnname() {
                return enname;
            }

            public void setEnname(String enname) {
                this.enname = enname;
            }

            public String getFcl() {
                return fcl;
            }

            public void setFcl(String fcl) {
                this.fcl = fcl;
            }

            public String getFl() {
                return fl;
            }

            public void setFl(String fl) {
                this.fl = fl;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getJs() {
                return js;
            }

            public void setJs(String js) {
                this.js = js;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getNf() {
                return nf;
            }

            public void setNf(String nf) {
                this.nf = nf;
            }

            public String getPlaydesc() {
                return playdesc;
            }

            public void setPlaydesc(String playdesc) {
                this.playdesc = playdesc;
            }

            public String getRelvsid() {
                return relvsid;
            }

            public void setRelvsid(String relvsid) {
                this.relvsid = relvsid;
            }

            public String getSbpd() {
                return sbpd;
            }

            public void setSbpd(String sbpd) {
                this.sbpd = sbpd;
            }

            public String getSbsj() {
                return sbsj;
            }

            public void setSbsj(String sbsj) {
                this.sbsj = sbsj;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getVsid() {
                return vsid;
            }

            public void setVsid(String vsid) {
                this.vsid = vsid;
            }

            public String getYz() {
                return yz;
            }

            public void setYz(String yz) {
                this.yz = yz;
            }

            public String getZcr() {
                return zcr;
            }

            public void setZcr(String zcr) {
                this.zcr = zcr;
            }

            public String getZy() {
                return zy;
            }

            public void setZy(String zy) {
                this.zy = zy;
            }
        }
    }

    public static class VideoBean {
        /**
         * em : CM01
         * img : http://p5.img.cctvpic.com/fmspic/2017/02/10/83fa86f6848c44dabfba29220fb904a6-99.jpg
         * len : 00:02:58
         * order : 60
         * ptime : 2017-02-10 12:02:45
         * t : 《77滚滚秀》 20170210 第六十期：开年散步趴！
         * url : http://tv.cntv.cn/video/VSET100272959126/83fa86f6848c44dabfba29220fb904a6
         * vid : 83fa86f6848c44dabfba29220fb904a6
         * vsid : VSET100272959126
         */

        private String em;
        private String img;
        private String len;
        private String order;
        private String ptime;
        private String t;
        private String url;
        private String vid;
        private String vsid;

        public String getEm() {
            return em;
        }

        public void setEm(String em) {
            this.em = em;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getLen() {
            return len;
        }

        public void setLen(String len) {
            this.len = len;
        }

        public String getOrder() {
            return order;
        }

        public void setOrder(String order) {
            this.order = order;
        }

        public String getPtime() {
            return ptime;
        }

        public void setPtime(String ptime) {
            this.ptime = ptime;
        }

        public String getT() {
            return t;
        }

        public void setT(String t) {
            this.t = t;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getVid() {
            return vid;
        }

        public void setVid(String vid) {
            this.vid = vid;
        }

        public String getVsid() {
            return vsid;
        }

        public void setVsid(String vsid) {
            this.vsid = vsid;
        }
    }
}
