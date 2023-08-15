Vue.createApp({
    data(){
        return {
            users: [],
            yhm:"",
            yhsf:"",
            zcsj:"",
            sjh:"",
            sex:"",
            email:""
        }
    },
    methods:{
        listUsers(){
            axios({
                method:"get",
                url:"/iBook/user",
                params:{
                    yhm:this.yhm,
                    yhsf:this.yhsf,
                    zcsj:this.zcsj,
                    sjh:this.sjh,
                    sex:this.sex,
                    email:this.email
                }
            }).then(res => {
                this.users = res.data;
            })
        },
        clearData(){
            this.yhm = "";
            this.yhsf = "";
            this.zcsj = "";
            this.sjh = "";
            this.sex = "";
            this.email = "";
        },
        doDelete(id){
            axios({
                method:"delete",
                url:"/iBook/user/"+id,
            }).then(res => {
                let ret = res.data;
                if(ret){
                    this.listUsers();
                }else{
                    alert("删除失败！");
                }
            })
        },
        doUpdate(user){
            sessionStorage.setItem("update_user",JSON.stringify(user));
            location = "userUpdate.html";
        }
    },
    mounted(){
        this.listUsers();
    }
}).mount("#contentPanel");