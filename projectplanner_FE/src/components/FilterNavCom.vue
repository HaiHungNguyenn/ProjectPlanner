<template>
  <nav>
    <!-- <router-link :to="{ path: '/', query: { status: 'all' } }">View All</router-link> 
    <router-link :to="{ path: '/', query: { status: 'completed' } }">COMPLETED</router-link>
    <router-link :to="{ path: '/', query: { status: 'ongoing' } }">ONGOING</router-link> -->
    <button @click="emitClickEvent('all')" :class="{ 'active-button': activeButton === 'all' }">View All</button>
    <button @click="emitClickEvent('completed')" :class="{ 'active-button': activeButton === 'completed' }">COMPLETED</button>
    <button @click="emitClickEvent('ongoing')" :class="{ 'active-button': activeButton === 'ongoing' }">ONGOING</button>

  </nav>
  <router-view />
</template>
<script>
export default {
  data(){
    return{
      activeButton: 'all',
    }
  },
  methods:{
    emitClickEvent(type) {
      this.activeButton = type;
      this.$emit('navButtonClick',type);
    },
  }
}
</script>
<style scoped>
button{
  border: none;
  font-size: 20px;  
  margin: 0px 10px;
  background-color:white ;
  color: #ccc;
  font-weight: bold;
}
button:hover{
  color: black;
}
nav {
  padding: 30px;
}



nav a.router-link-exact-active {
  color: black;
}
.active-button {
  color: black;
  border-radius:10px ;

}
</style>
