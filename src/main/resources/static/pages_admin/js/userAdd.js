Vue.createApp({
    data(){
        return {
            yhm:"",
            pwd:"",
            yhsf:2,
            tipYhm:"*",
            tipPwd:"*",
            tipMsg:"&nbsp;"
        }
    },
    methods:{
        checkYhm(){
            this.tipMsg = "&nbsp;";
            if(this.yhm == ''){
                this.tipYhm = "用户名不能为空";
                return false;
            }else{
                this.tipYhm = "*";
                return true;
            }
        },
        checkPwd(){
            if(/^\d{6}$/.test(this.pwd) == false){
                this.tipPwd = "密码应为6为数字";
                return false;
            }else{
                this.tipPwd = "*";
                return true;
            }
        },
        doAdd(){
            if(this.checkYhm() && this.checkPwd()){
                axios({
                    method:"post",
                    url:"/iBook/user",
                    params:{
                        yhm:this.yhm,
                        pwd:this.pwd,
                        yhsf:this.yhsf
                    }
                }).then(res => {
                    let ret = res.data;
                    if(ret == true){
                        location = "userMgr.html";
                    }else{
                        this.tipMsg = "用户名已被注册";
                    }
                })
            }
        }
    }
}).mount("#panel")