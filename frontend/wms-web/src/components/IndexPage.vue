<template>
  <el-container style="height: 100%; border: 1px solid #eee">
  <el-aside width="200px" style="background-color: rgb(238, 241, 246); height: 100%">
    <AsideCom></AsideCom>
  </el-aside>
  
  <el-container style="height: 100%">
    <el-header style="text-align: right; font-size: 12px">
      <HeaderCom></HeaderCom>
    </el-header>
    
    <el-main style="height: 100%">
      <MainCom></MainCom>
    </el-main>
  </el-container>
</el-container>
</template>

<script>
import AsideCom from './AsideCom.vue';
import HeaderCom from './HeaderCom.vue';
import MainCom from './MainCom.vue';

export default {
    name: "IndexPage",
    components: {AsideCom, HeaderCom, MainCom},
    // data() {
    //   const item = {
    //     date: '2016-05-02',
    //     name: 'Tom',
    //     address: 'No. 189, Grove St, Los Angeles'
    //   };
    //   return {
    //     tableData: Array(20).fill(item)
    //   }
    // }
}
</script>

<style>
  .el-header {
    background-color: #B3C0D1;
    color: #333;
    line-height: 60px;
  }

  .el-main {
    padding: 5px;
  }
  
  .el-aside {
    color: #333;
  }
</style>