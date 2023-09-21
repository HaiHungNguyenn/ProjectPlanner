import { createApp } from 'vue'
import App from './App.vue'
import router from './routes'
import 'bootstrap/dist/css/bootstrap.min.css';
import { library } from '@fortawesome/fontawesome-svg-core'
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'
import { faTrashCan,faPenToSquare} from '@fortawesome/free-regular-svg-icons'
import {faCheck} from '@fortawesome/free-solid-svg-icons'
library.add(faTrashCan)
library.add(faPenToSquare)
library.add(faCheck)

createApp(App).use(router).component('font-awesome-icon', FontAwesomeIcon).mount('#app')
