const BASE_URL = "http://localhost:8080/api/project"
import axios from 'axios'
class MainService{
    getProjects(){
        return axios.get(BASE_URL+"/");
    }
    getProjectDetail(id){
        return axios.get(BASE_URL+"/"+id);
    }
    getOnGoingProject(){
        return axios.get(BASE_URL+"/uncompleted");
    }
    getCompletedProject(){
        return axios.get(BASE_URL+"/completed");
    }
    addProject(project){
        return axios.post(BASE_URL + "/add", project, {
            headers: { "Content-Type": "application/json" }
          });
    }
    deleteProject(id){
        return axios.delete(BASE_URL + "/"+id)
    }
    updateProject(id,project){
        return axios.put(BASE_URL + "/"+id,project, {
            headers: { "Content-Type": "application/json" }
          });
    }
    changeStatus(id){
        return axios.put(BASE_URL + "/update/"+id);
    }

}
export default new MainService()