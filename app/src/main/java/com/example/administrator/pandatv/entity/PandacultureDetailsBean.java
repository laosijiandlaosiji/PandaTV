package com.example.administrator.pandatv.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by li on 2017/8/1.
 */

public class PandacultureDetailsBean {
//

    /**
     * video : [{"em":"CM01","img":"http://p5.img.cctvpic.com/fmspic/2016/10/19/e2ce1fa0a295447cb242235167d52ca8-129.jpg","len":"00:04:18","order":"1","ptime":"2016-10-19 15:40:11","t":"《特别节目》 20161019 戏曲动画·《花中君子》","url":"http://tv.cntv.cn/video/VSET100311356635/e2ce1fa0a295447cb242235167d52ca8","vid":"e2ce1fa0a295447cb242235167d52ca8","vsid":"VSET100311356635"},{"em":"CM01","img":"http://p3.img.cctvpic.com/fmspic/2016/10/19/84f27011346547c595d78b47a48eb6de-129.jpg","len":"00:03:32","order":"2","ptime":"2016-10-19 15:43:32","t":"《特别节目》 20161019 戏曲动画·《牡丹亭·惊梦》","url":"http://tv.cntv.cn/video/VSET100311356635/84f27011346547c595d78b47a48eb6de","vid":"84f27011346547c595d78b47a48eb6de","vsid":"VSET100311356635"},{"em":"CM01","img":"http://p2.img.cctvpic.com/fmspic/2016/10/19/02f061fc45164fcba7522db7af9df27f-129.jpg","len":"00:04:23","order":"3","ptime":"2016-10-19 15:46:10","t":"《特别节目》 20161019 戏曲动画·《林冲夜奔》","url":"http://tv.cntv.cn/video/VSET100311356635/02f061fc45164fcba7522db7af9df27f","vid":"02f061fc45164fcba7522db7af9df27f","vsid":"VSET100311356635"},{"em":"CM01","img":"http://p4.img.cctvpic.com/fmspic/2016/10/19/2b693803101f4cb1930cc1694362e67e-249.jpg","len":"00:08:52","order":"4","ptime":"2016-10-19 15:50:35","t":"《特别节目》 20161019 戏曲动画·《讨学钱》","url":"http://tv.cntv.cn/video/VSET100311356635/2b693803101f4cb1930cc1694362e67e","vid":"2b693803101f4cb1930cc1694362e67e","vsid":"VSET100311356635"},{"em":"CM01","img":"http://p1.img.cctvpic.com/fmspic/2016/10/19/a9bd9800609245c0b981611424a9c5fc-129.jpg","len":"00:04:42","order":"5","ptime":"2016-10-19 15:52:35","t":"《特别节目》 20161019 戏曲动画·《挑华车》","url":"http://tv.cntv.cn/video/VSET100311356635/a9bd9800609245c0b981611424a9c5fc","vid":"a9bd9800609245c0b981611424a9c5fc","vsid":"VSET100311356635"},{"em":"CM01","img":"http://p4.img.cctvpic.com/fmspic/2016/10/19/a7f2287539db429f8ab88973d7177ea5-129.jpg","len":"00:04:37","order":"6","ptime":"2016-10-19 15:53:58","t":"《特别节目》 20161019 戏曲动画·《武松打店》","url":"http://tv.cntv.cn/video/VSET100311356635/a7f2287539db429f8ab88973d7177ea5","vid":"a7f2287539db429f8ab88973d7177ea5","vsid":"VSET100311356635"}]
     * videoset : {"0":{"bj":"","cd":"","desc":"戏曲，是中国重要的艺术门类，有着悠久的历史，因为一代代戏曲演员的传承，得以保留至今。而随着时代和科技的发展，我们拥有了更丰富的文化传播载体和手段，一群来自中国戏曲学院、热爱传统文化的年轻人根据多个传统戏曲作品改编成一部部刻画细致、内容生动的动画短片，涉及到河北梆子、湖南花鼓戏、京剧、昆曲等多样门类。","dy":"","enname":"CNTV","fcl":"","fl":"熊猫文化","img":"http://p1.img.cctvpic.com/photoAlbum/vms/standard/img/2016/10/19/CHANdAyXtBuMEyXBFQq21NVT161019.JPG","js":"","name":"熊猫频道《原创戏曲动画》","nf":"2016","playdesc":"","relvsid":"","sbpd":"CNTV","sbsj":"","url":"http://tv.cntv.cn/videoset/VSET100311356635","vsid":"VSET100311356635","yz":"","zcr":"","zy":""},"count":"7"}
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
         * 0 : {"bj":"","cd":"","desc":"戏曲，是中国重要的艺术门类，有着悠久的历史，因为一代代戏曲演员的传承，得以保留至今。而随着时代和科技的发展，我们拥有了更丰富的文化传播载体和手段，一群来自中国戏曲学院、热爱传统文化的年轻人根据多个传统戏曲作品改编成一部部刻画细致、内容生动的动画短片，涉及到河北梆子、湖南花鼓戏、京剧、昆曲等多样门类。","dy":"","enname":"CNTV","fcl":"","fl":"熊猫文化","img":"http://p1.img.cctvpic.com/photoAlbum/vms/standard/img/2016/10/19/CHANdAyXtBuMEyXBFQq21NVT161019.JPG","js":"","name":"熊猫频道《原创戏曲动画》","nf":"2016","playdesc":"","relvsid":"","sbpd":"CNTV","sbsj":"","url":"http://tv.cntv.cn/videoset/VSET100311356635","vsid":"VSET100311356635","yz":"","zcr":"","zy":""}
         * count : 7
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
             * desc : 戏曲，是中国重要的艺术门类，有着悠久的历史，因为一代代戏曲演员的传承，得以保留至今。而随着时代和科技的发展，我们拥有了更丰富的文化传播载体和手段，一群来自中国戏曲学院、热爱传统文化的年轻人根据多个传统戏曲作品改编成一部部刻画细致、内容生动的动画短片，涉及到河北梆子、湖南花鼓戏、京剧、昆曲等多样门类。
             * dy :
             * enname : CNTV
             * fcl :
             * fl : 熊猫文化
             * img : http://p1.img.cctvpic.com/photoAlbum/vms/standard/img/2016/10/19/CHANdAyXtBuMEyXBFQq21NVT161019.JPG
             * js :
             * name : 熊猫频道《原创戏曲动画》
             * nf : 2016
             * playdesc :
             * relvsid :
             * sbpd : CNTV
             * sbsj :
             * url : http://tv.cntv.cn/videoset/VSET100311356635
             * vsid : VSET100311356635
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
         * img : http://p5.img.cctvpic.com/fmspic/2016/10/19/e2ce1fa0a295447cb242235167d52ca8-129.jpg
         * len : 00:04:18
         * order : 1
         * ptime : 2016-10-19 15:40:11
         * t : 《特别节目》 20161019 戏曲动画·《花中君子》
         * url : http://tv.cntv.cn/video/VSET100311356635/e2ce1fa0a295447cb242235167d52ca8
         * vid : e2ce1fa0a295447cb242235167d52ca8
         * vsid : VSET100311356635
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
