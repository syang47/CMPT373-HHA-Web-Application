import { createStore } from "vuex";
import { auth } from "@/store/auth.module";

const newStore = createStore({
  state: {},
  mutations: {},
  actions: {},
  modules: {
    auth,
  },
});

export default newStore;