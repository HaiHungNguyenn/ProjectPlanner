<template>
    <div class="container " >
        <div class="title" >
            <FilterNav @navButtonClick = "handleNavButtonClick"/>
        </div>
        <div class="contain">
            <div class="products" v-for="project in projects" :key="project.id" >
                <SingleProduct :project="project" @handleDelete = "deleteProject" @handleChangeStatus="changeStatus"/>
            </div>

        </div>
    </div>
</template>
<script>
import FilterNav from '../components/FilterNavCom.vue'
import SingleProduct from '../components/SingleProductCom.vue'
import service from '../service/MainService.js'



export default {
    
    data(){
        return{
            projects:[],

        }
    },
    components:{
        FilterNav,
        SingleProduct
    },
    methods:{
        getProjects(){
            service.getProjects().then((response) => {
                this.projects = response.data
            });
        },
        getOnGoingProject(){
            service.getOnGoingProject().then((response) => {
                this.projects = response.data
            })
        },
        getCompletedProject(){
            service.getCompletedProject().then((response) => {
                this.projects = response.data
            })
        },
        handleNavButtonClick(status) {
            if(status === 'ongoing'){
                this.getOnGoingProject();
            }else if(status === 'completed'){
                this.getCompletedProject();
            }else if(status ==='all'){
            this.getProjects()
        }
        },
        deleteProject(id){
            service.deleteProject(id).then((response) =>{
                this.projects = response.data
            })
            
        },
        changeStatus(id){
            service.changeStatus(id).then((response) =>{
                this.projects = response.data
            })
          
        }
    },
    mounted(){

        this.getProjects()    
        
    },
    updated(){
            const type = this.$router.query 
            if(type==="/"){
                 this.getProjects()    
            }

    }
}
</script>
<style scoped>
    .container{ 
        margin: 0 auto;
        display: block;
        width: 80%;
    }
    .title{
        display: flex;
    }
    .float-left{
        float: left;
    }
    .mg{
        margin: 10px 0px
    }
    .bd{
        border: 2px solid red
    }
    .products{
        display: flex;
        width: 50%;
        align-content: center;
        flex-direction: column;
        margin: 20px 10px;
        align-items: center;
        display: block;
    }
    .contain{
        text-align: center;
        display: flex;
        flex-direction: column;
        justify-content: space-evenly;
        align-items: center;
    }
</style>