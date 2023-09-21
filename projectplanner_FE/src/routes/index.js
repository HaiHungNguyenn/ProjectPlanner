import {createRouter,createWebHistory} from 'vue-router'
import Home from '../pages/HomePage.vue'
import AddProject from '../pages/AddProject.vue'
import EditProject from '../pages/EditProject.vue'
const routes = [
    {path:'/',component:Home},
    {path:'/add',component:AddProject},
    {path:'/projects/:id',component:EditProject},

]

const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes
  })
  
  export default router
  