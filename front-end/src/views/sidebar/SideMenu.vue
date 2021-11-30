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
                    title:  this.$t("homePage.maternity"),
                }
                departments.push(d1);
                let d2 = {
                    href:"/rehab",
                    title:  this.$t("homePage.rehab"),
                }
                departments.push(d2);
                let d3 = {
                    href:"/community_health",
                    title:  this.$t("homePage.communityHealth"),
                }
                departments.push(d3);
                let d4 = {
                    href:"/nicu_paed",
                    title:  this.$t("homePage.nicuPaed"),
                }
                departments.push(d4);
                // return departments.push(d1,d2,d3,d4);
            } else {
                let d = {
                    href: '/' + token.department.toLowerCase(),
                    title: this.$t("departmentPage." + token.department.toLowerCase().replace("_","")),
                }
                // return departments.push(d);
                departments.push(d);
            }          
            return [
                {
                    header: "Hope Health Action",
                    hiddenOnCollapse: true
                },
                {
                    href:'/leadersboard',
                    title: this.$t("homePage.leaderBoard"),
                    hiddenOnCollapse: true
                },
                {
                    href:'/announcement',
                    title: this.$t("announcementPage.addAnnouncement"),
                    hiddenOnCollapse: true
                },
                {
                    href:'/dataDisplay',
                    title: "DataDisplay",
                    hiddenOnCollapse: true
                },
                {
                    href:'/message_board',
                    title: this.$t("homePage.messageBoard"),
                    hiddenOnCollapse: true
                },
                {
                    href:'/casestudy',
                    title: this.$t("homePage.caseStudy"),
                    hiddenOnCollapse: true
                },
                {
                    href:'/',
                    title: "Departments",
                    child: departments,
                    hiddenOnCollapse: true
                },  
                {
                    href: "/register",
                    title: this.$t("header.register"),
                    hiddenOnCollapse: true
                },      
            ];
        },
    },
});

</script>