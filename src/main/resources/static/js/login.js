Vue.createApp({
    data(){
        return {
           user:{
               yhm:"",
               pwd:""
           }
        }
    },
    methods:{
        checkYhm(){
            if(this.user.yhm == ''){
                alert("用户名不能为空");
                return false;
            }
            return true;
        },
        checkPwd(){
            if(this.user.pwd.length != 6){
                alert("密码长度不对");
                return false;
            }
            return true;
        },
        doLogin(){
            if(this.checkYhm() && this.checkPwd()){
                axios({
                    method:"get",
                    url:"/iBook/user/one",
                    params:this.user
                }).then(res => {
                    console.log(res);
                    let yh = res.data;
                    if (yh != null) {
                        sessionStorage.setItem("userJson",JSON.stringify(yh));
                        if (yh.yhsf == 1 || yh.yhsf == 2) {
                            // 是管理员，则跳转到 admin.html 页面
                            location = "pages_admin/admin.html";
                        } else if(yh.yhsf == 3) {
                            // 是普通用户，则跳转到 user.html 页面
                            location = "pages_user/user.html";
                        } else{
                            // 非法用户，则跳转到 index.html 首页
                            location = "index.html";
                        }
                    }else{
                        alert("账户不存在");
                    }
                });
            }
        }
    }
}).mount("#form1");