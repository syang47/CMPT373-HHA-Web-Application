<style scoped>
    .sidebar-overlay {
        position: fixed;
        width:100%;
        height:100%;
        top:150;
        left:0;
        background-color: #000;
        opacity: 0.5;
        z-index:900;
    }
</style>
<template>
    
    <sidebar-menu
        :collapsed="collapsed" 
        :menu="menu"
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
        var departments = [] as any;
        let token = JSON.parse(localStorage.getItem('user')!);
        if(token.roles[0].authority == "ROLE_ADMIN" || token.roles[0].authority == "ROLE_HOSPITALADMIN"){
            let d = {
                href:"/maternity",
                title:  this.$t("homePage.maternity"),
            }
            departments.push(d);
            d = {
                href:"/rehab",
                title:  this.$t("homePage.rehab"),
            }
            departments.push(d);
            d = {
                href:"/community_health",
                title:  this.$t("homePage.communityHealth"),
            }
            departments.push(d);
            d = {
                href:"/nicu_paed",
                title:  this.$t("homePage.nicuPaed"),
            }
            departments.push(d);

        } else {
            let d = {
                href: '/' + token.department.toLowerCase(),
                title: this.$t("departmentPage." + token.department.toLowerCase().replace("_","")),
            }
            departments.push(d);
        }
        
        

        return {

            menu:[
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
                }      
            ],
            collapsed: false,
            isOnMobile: false,

        }
    },
});

</script>