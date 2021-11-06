import VueRouter, { Route } from 'vue-router'
import { ComponentCustomProperties } from 'vue'
import Vue, {VNode} from "vue"

declare global {
    namespace JSX {
        interface Element extends VNode {}
        interface ElementClass extends Vue {}
        interface IntrinsicElements {
            [elem: string]: any
        }
    }
}

/* eslint-disable */
declare module "*.vue"{
  import { ComponentOptions} from "vue";
  const Component: ReturnType<typeof defineComponent>;
  export default Component;
}

declare module 'vue/types/vue' {
  interface Vue {
    $router: VueRouter
  }
}