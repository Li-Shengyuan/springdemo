Vue.createApp({
    data(){
        return {
            yhm:"",
            pwd:"",
            pwd2:""
        }
    },
    methods:{
        checkYhm(){
            if(this.yhm == ''){
                alert("用户名不能为空");
                return false;
            }
            return true;
        },
        checkPwd(){
            if(/^\d{6}$/.test(this.pwd) == false){
                alert("密码非法");
                return false;
            }
            return true;
        },
        checkPwd2(){
            if(this.pwd != this.pwd2){
                alert("两次输入的密码不一致");
                return false;
            }
            return true;
        },
        doRegister(){
            if(this.checkYhm() && this.checkPwd() && this.checkPwd2()){
                axios({
                    method:"post",
                    url:"/iBook/user/"+this.yhm+"/"+this.pwd
                }).then(res => {
                    let ret = res.data;
                    if(ret == true){
                        location = "login.html";
                    }else{
                        alert("用户名已被注册");
                    }
                }).catch(err => {
                    console.log(err);
                });
            }
        }
    }
}).mount("#form1")