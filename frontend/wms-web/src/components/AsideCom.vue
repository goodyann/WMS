<template>
    <el-menu 
        style="height: 100vh;" 
        background-color="#545c64"
        text-color="#fff"
        active-text-color="#ffd04b"
        default-active="/Home"
        :collapse="isCollapse"
        :collapse-transition="false">
      <el-menu-item index="/Home"> 
        <i class="el-icon-s-home"></i>
        <span slot="title">Main menu</span>
      </el-menu-item>

      <el-menu-item index="/One"> 
        <i class="el-icon-s-flag"></i>
        <span slot="title">Navigator one</span>
      </el-menu-item>

      <el-menu-item index="/Two"> 
        <i class="el-icon-s-opportunity"></i>
        <span slot="title">Navigator two</span>
      </el-menu-item>
    </el-menu>
</template>

<script>
export default {
  name:"AsideCom",
  data() {
    return {
      // isCollapse: false,
    }
  },
  props: {
    isCollapse: Boolean
  }
}
</script>