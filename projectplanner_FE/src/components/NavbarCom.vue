<template>
  <nav>
    <router-link to="/">Projects</router-link> 
    <router-link to="/add">Add a new project</router-link>
  </nav>
  <router-view />
</template>
<style scoped>
nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  font-size: 20px;
  color: #818080;
  text-decoration: none; 
  margin: 0px 10px;
}

nav a.router-link-exact-active {
  color: black;
}
</style>
