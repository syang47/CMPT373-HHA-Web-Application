<template>
    <sidebar-menu
        :collapsed="collapsed" 
        :menu="menu"
        :key="menu.title"
        :showOneChild="true"
        :relative="true"
        >
    </sidebar-menu>
</template>

<script lang="ts" type="text/typescript">
import { defineComponent } from 'vue';
export default defineComponent({
    name: "SideMenu",
    data: function() {        
        return {
            collapsed: false,
            isOnMobile: false,
            
        }
    },
    computed: {
        menu() {
            var departments = [] as any;
            let token = JSON.parse(localStorage.getItem('user')!);
            if(token.roles[0].authority == "ROLE_ADMIN" || token.roles[0].authority == "ROLE_HOSPITALADMN"){
                let d1 = {
                    href:"/maternity",
                    title:  this.$t("sideBar.maternity"),
                }
                departments.push(d1);
                let d2 = {
                    href:"/rehab",
                    title:  this.$t("sideBar.rehab"),
                }
                departments.push(d2);
                let d3 = {
                    href:"/community_health",
                    title:  this.$t("departmentPage.communityHealth"),
                }
                departments.push(d3);
                let d4 = {
                    href:"/nicu_paed",
                    title:  this.$t("departmentPage.nicupaed"),
                }
                departments.push(d4);
                // return departments.push(d1,d2,d3,d4);
            } else {
                let d = {
                    href: '/' + token.department.toLowerCase(),
                    title: this.$t("sideBar." + token.department.toLowerCase().replace("_","")),
                }
                // return departments.push(d);
                departments.push(d);
            }          
            return [
                {
                    header: this.$t("sideBar.HHA"),
                    hiddenOnCollapse: true
                },
                {
                    href:'/leadersboard',
                    title: this.$t("sideBar.leaderBoard"),
                    hiddenOnCollapse: true
                },
                {
                    href:'/dataDisplay',
                    title: this.$t("sideBar.dataDisplay"),
                    hiddenOnCollapse: true
                },
                {
                    href:'/message_board',
                    title: this.$t("sideBar.messageBoard"),
                    hiddenOnCollapse: true
                },
                {
                    href:'/casestudy',
                    title: this.$t("sideBar.caseStudy"),
                    hiddenOnCollapse: true
                },
                {
                    href:'/',
                    title: this.$t("sideBar.departments"),
                    child: departments,
                    hiddenOnCollapse: true
                },  
                {
                    href: "/register",
                    title: this.$t("sideBar.register"),
                    hiddenOnCollapse: true
                },      
            ];
        },
    },
});

</script>