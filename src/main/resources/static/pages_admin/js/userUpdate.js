Vue.createApp({
    data(){
        return {
            yhbh:"",
            yhm:"",
            yhsf:"",
            tipMsg:"&nbsp;"
        }
    },
    methods:{
        doAdd(){
            axios({
                method:"put",
                url:"/iBook/user",
                params:{
                    yhbh:this.yhbh,
                    yhsf:this.yhsf
                }
            }).then(res => {
                let ret = res.data;
                if(ret == true){
                    this.tipMsg = "修改成功";
                }else{
                    this.tipMsg = "更新失败";
                }
            })
        },
        goBack(){
            location = "userMgr.html";
        }
    },
    mounted(){
        let uu = sessionStorage.getItem("update_user");
        // console.log(uu)
        let user = JSON.parse(uu);
        this.yhbh = user.yhbh;
        this.yhm = user.yhm;
        this.yhsf = user.yhsf == '普通管理员'? 2 : 3;
    }
}).mount("#panel")