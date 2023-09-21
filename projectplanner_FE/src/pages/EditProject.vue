<template>
    <form action="" class="addForm w-50">
        <div class="mb-3">
            <label for="exampleFormControlInput1" class="form-label">Title</label>
            <input type="text" class="form-control" v-model="project.title">
        </div>
        <div class="mb-3">
            <label for="exampleFormControlTextarea1" class="form-label">Detail</label>
            <textarea  class="form-control" rows="3"  v-model="project.detail"></textarea>
        </div>
        <button class="btn btn-success" @click.stop.prevent="submitForm()">Update Project</button>
    </form>
   
</template>
<style scoped>
    .addForm{
        margin: 0px auto;
        background-color: beige;
        padding: 30px 20px;
        border-radius:15px ;
    }
    .form-label{
        font-size: 25px;
        float: left;
        color: gray;
    }
</style>
<script>
import service from '../service/MainService'
export default {
    data() {
        return {
            projectId: null ,
            project:{
                id:'',
                title:'',
                detail:'',
                status:''
            }
        };
    },
    methods:{
        getProjectdetail(id){
            service.getProjectDetail(id).then((response) => {
                this.project = response.data
            })
        },
        submitForm(){
            const updateData = {
                id : this.project.id,
                title : this.project.title,
                detail : this.project.detail,
                status : this.project.status
            }
            service.updateProject(updateData.id,updateData)
            window.location.href = '/'
        }
    },
    created(){
        this.projectId = this.$route.params.id;
        this.getProjectdetail(this.projectId);
        
    }
}
</script>


































