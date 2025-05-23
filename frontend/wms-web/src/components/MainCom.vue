// TODO: Split Main component from index page out (but there exists an error. Tutorial p12)
<template>
    <el-table :data="tableData">
        <el-table-column prop="date" label="Date" width="140">
        </el-table-column>
        <el-table-column prop="name" label="Name" width="120">
        </el-table-column>
        <el-table-column prop="address" label="Address">
        </el-table-column>
      </el-table>
</template>

<script>

export default {
    name: "MainCom",
    data() {
      const item = {
        date: '2016-05-02',
        name: 'Tom',
        address: 'No. 189, Grove St, Los Angeles'
      };
      return {
        tableData: Array(20).fill(item)
      }
    },
    methods: {
        loadGet() {
            this.$axios.get(this.$httpUrl + '/user/list').then(res=>res.data).then(res=>{
                console.log(res);
            });
        },
        loadPost() {
          this.$axios.post(this.$httpUrl + '/user/listPage', {
            pageNum: 1,
            pageSize: 10,
            param: {
              name: ''
            }
          }).then(res => {
            console.log('data:', res.data);
          }).catch(err => {
            console.error('error:', err);
          });
        }
    },
    beforeMount() {
        // this.loadGet();
        this.loadPost();
    }
}
</script>