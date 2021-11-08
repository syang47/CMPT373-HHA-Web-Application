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

declare module 'vue/types/vue' {
  interface Vue {
      $router: VueRouter;
      $route: Route;
      $store: Store<any>;
      $api: any;
      $mock: any;
      $configs: any;
  }
}