<template>
    <form action="" class="addForm w-50" >
        <div class="mb-3">
            <label for="exampleFormControlInput1" class="form-label">Title</label>
            <input type="text" class="form-control" v-model="project.title">
        </div>
        <div class="mb-3">
            <label for="exampleFormControlTextarea1" class="form-label">Detail</label>
            <textarea  class="form-control" rows="3" v-model="project.detail"></textarea>
        </div>
        <button class="btn btn-success" @click.stop.prevent="submitForm()" @click="emitClickEvent">Add Project</button>
    </form>
   
</template>
<script>
import service from '../service/MainService.js'
export default {
    data(){
        return{
            project:{
                id:'',
                title:'',
                detail:'',
                status:''
            }
        }
    },
    methods:{
        
        submitForm(){
            const addData =  {
                id: '0',
                title : this.project.title,
                detail: this.project.detail,
                status : false
            }
            ;
            service.addProject(addData)
            window.location.href = '/'
        },
    }
}
</script>
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


































