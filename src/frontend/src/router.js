import Vue from "vue";
import Router from "vue-router";

Vue.use(Router);

export default new Router({
    mode: "history",
    routes: [
        {
            path: "/",
            alias: "/matches",
            name: "matches",
            component: () => import("./components/Matches")
        },
        {
            path: "/betslip",
            name: "betslip",
            component: () => import("./components/Betslips")
        },
        {
            path: "/wallet",
            name: "wallet",
            component: () => import("./components/Wallet")
        }
    ]
});