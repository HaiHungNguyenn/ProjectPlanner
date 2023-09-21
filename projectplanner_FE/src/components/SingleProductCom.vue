<template>
    <div class="container-fluid" :class="{'complete':project.status}">
        <div class="main">
            <div class="title" @click="showDetail =! showDetail">
                <h3>{{project.title}}</h3>
            </div>
            <div class="action" >
                <font-awesome-icon class="icon" icon="fa-regular fa-trash-can " @click="emitClickEvent(project.id)"/>
                
                <router-link :to="`/projects/${project.id}`">
                    <font-awesome-icon class="icon" icon="fa-regular fa-pen-to-square i" />
                </router-link>
                

                <font-awesome-icon  icon="fa-solid fa-check " :class="(project.status) ? 'completed' : 'icon' " @click="project.status ? '' : changeStatus(project.id)"/>
                <router-view />

            </div>
        </div>
        <div class="sub" v-if="showDetail" @click="showDetail =! showDetail">
            <h4>{{project.detail}}</h4>
        </div>
    </div>
</template>
<script>
export default {
    props:['project']
    ,
    data(){
        return{
            showDetail : false
        }
    },
    methods:{
        emitClickEvent(data){
            this.$emit('handleDelete',data)
        },
        changeStatus(id){
            this.$emit('handleChangeStatus',id)
        }
    }
}
</script>>
<style scoped>
    .container-fluid{
        display: flex;
        flex-direction: column;
        border-left: 5px solid red;
        border-radius: 5px;
        background-color: #e0e0e0;
    }
    .complete{
        border-left: 5px solid rgb(18, 249, 18)  !important;
    }
    .complete-icon{

    }
  
    .completed{
        color: rgb(18, 249, 18);
        cursor: pointer;
    }
  
   .main{
    width: 100%;
    height: 10vh;
    display: flex;
    flex-direction: row;
    text-align: center;
   }
   .sub{
    width: 100%;
    height: auto;
    display: flex;
    flex-direction: row;
    text-align: center;
    padding: 10px 30px;

   }
  
   .title{
    width: 80%;
    display: flex;
    justify-content: center;
    align-items: center;
    cursor: pointer;
   }
   .title:hover{
        opacity: 0.7;

   }
   .sub:hover{
        cursor: pointer;
   }
   
   .action{
    display: block;
    width: 20%;
    display: flex;
    justify-content: space-evenly;
    align-items: center;
    cursor: pointer;
    font-size: 25px;
   }
   .icon{
    color: black;
    padding: 10px;
    border-radius: 5px;
   }
   .icon:hover{
    color: rgb(80, 80, 235);
    transition: ease-in-out ;
    background-color: #969696;
   }
    
</style>