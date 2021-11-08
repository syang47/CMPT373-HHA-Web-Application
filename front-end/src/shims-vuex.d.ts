import { ComponentCustomProperties } from 'vue'
import { Store } from '@/store';// path to store file


declare module '@vue/runtime-core' {
  // declare your own store states
  interface State {
    count: number
  }

  // provide typings for `this.$store`
  interface ComponentCustomProperties {
    $store: Store
  }


}