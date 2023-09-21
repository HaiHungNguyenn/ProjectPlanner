import 'font-awesome/css/font-awesome.min.css' 
import { createVuetify } from 'vuetify'
import { aliases, fa } from 'vuetify/iconsets/fa4'

export default createVuetify({
  icons: {
    defaultSet: 'fa',
    aliases,
    sets: {
      fa,
    },
  },
})