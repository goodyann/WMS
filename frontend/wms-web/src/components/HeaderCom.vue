<template>
    <div style="display: flex; line-height: 50px;">
        <div style="font-size: 20px">
            <i :class="icon" style="font-size: 20px; cursor: pointer" @click="collapse"></i>
        </div>
        <div style="flex: 1; text-align: center; font-size: 30px">
            <span>Welcome to Warehouse Management System</span>
        </div >
        <div style="width: 100px;">
            <el-dropdown @command="handleCommand">
                <span>Tom</span><i class="el-icon-arrow-down" style="margin-left: 5px"></i>
                <el-dropdown-menu slot="dropdown">
                    <el-dropdown-item command="profile">Profile</el-dropdown-item>
                    <el-dropdown-item command="logout">Log out</el-dropdown-item>
                </el-dropdown-menu>
            </el-dropdown>
        </div> 
    </div>
</template>

<script>

export default {
    name: "HeaderCom",
    props: {
        icon: String
    },
    methods: {
        handleCommand(command) {
            if (command === 'profile') {
                this.toUser();
            } else if (command === 'logout') {
                this.logOut();
            }
        },
        toUser() {
            console.log('to_user');
        },
        logOut() {
            console.log('log_out');
        },

        collapse() {
            this.$emit('doCollapse')
        }
    }
}
</script>