// TODO: Split Main component from index page out (but there exists an error. Tutorial p12)
<template>
    <el-table :data="tableData"
          :header-cell-style="{background: 'lightgrey'}"
          border
        >
        <el-table-column prop="id" label="ID" width="60">
        </el-table-column>
        <el-table-column prop="no" label="NO." width="120">
        </el-table-column>
        <el-table-column prop="name" label="Name" width="160">
        </el-table-column>
        <el-table-column prop="age" label="Age" width="60">
        </el-table-column>
        <el-table-column prop="sex" label="Gender" width="100">
          <template slot-scope="scope">
            <el-tag
              :type="scope.row.sex === 0 ? 'success' : 'danger'"
              disable-transitions>{{scope.row.sex === 0 ? 'female' : 'male'}}
            </el-tag>
          </template>
        </el-table-column>
        <el-table-column prop="role_id" label="Role" width="140">
          <template slot-scope="scope">
            <el-tag
              :type="scope.row.role_id === 0 ? 'success' : (scope.row.roleId === 1 ? 'success' : 'primary')"
              disable-transitions>{{scope.row.role_id === 0 ? 'Super Admin' : (scope.row.roleId === 1 ? 'Admin' : 'Basic User')}}
            </el-tag>
          </template>
        </el-table-column>
        <el-table-column prop="phone" label="Phone" width="180">
        </el-table-column>
        <el-table-column prop="operate" label="Operations" width="180">
          <el-button size="small" type="success">Edit</el-button>
          <el-button size="small" type="danger">Delete</el-button>
        </el-table-column>
      </el-table>
</template>

<script>

export default {
    name: "MainCom",
    data() {
      // replace the constant data by the data from the table
      // const item = {
      //   date: '2016-05-02',
      //   name: 'Tom',
      //   address: 'No. 189, Grove St, Los Angeles'
      // };
      return {
        // tableData: Array(20).fill(item)
        tableData:[]
      }
    },
    methods: {
        loadGet() {
            this.$axios.get(this.$httpUrl + '/user/list').then(res=>res.data).then(res=>{
                console.log(res)
            });
        },
        loadPost() {
          this.$axios.post(this.$httpUrl + '/user/query', {
            // pageNum: 1,
            // pageSize: 10,
            // param: {
            //   name: ''
            // }
            name:''
          }).then(res => {
            // TODO: here the code returned is always not 200 and then alert, idk why now
            console.log('data:', res);
            // this.tableData = res.data
            if(res.status == 200) {
              this.tableData = res.data
            } else {
              alert('fail to retrieve data')
            }
            
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