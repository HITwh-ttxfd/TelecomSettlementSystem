<template>
  <div class="wrapper">
    <div class="operations">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item :to="{ path: '/center' }">首页</el-breadcrumb-item>
        <el-breadcrumb-item>收款稽核</el-breadcrumb-item>
        <el-breadcrumb-item>通知单收入</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <el-card shadow="always">
      <el-table :data="table">
        <el-table-column
          align="center"
          label="城市"
          prop="cityCode">
        </el-table-column>
        <el-table-column
          align="center"
          label="产品"
          prop="productCode">
        </el-table-column>
        <el-table-column
          align="center"
          label="通知单类型"
          prop="businessTypeCode">
        </el-table-column>
        <el-table-column
          align="center"
          label="收款日期"
          prop="business_record_date">
        </el-table-column>
        <el-table-column
          align="center"
          label="收入金额"
          prop="businessFee">
        </el-table-column>
        <el-table-column
          align="center"
          label="录入人员"
          prop="recordOperator">
        </el-table-column>
        <el-table-column
          align="center"
          label="稽核状态"
          prop="checkStatus">
        </el-table-column>
        <el-table-column
          align="center"
          label="稽核人"
          prop="checkPerson">
        </el-table-column>
        <el-table-column
          align="center"
          label="稽核时间"
          prop="checkTime">
        </el-table-column>
        <el-table-column align="center" label="稽核状态" width="150px">
          <template slot-scope="scope">
            <el-button
              size="mini"
              type="success"
              @click="pass(scope.$index, scope.row)">通过
            </el-button>
            <el-button
              size="mini"
              type="danger"
              @click="reject(scope.$index, scope.row)">拒绝
            </el-button>
          </template>
        </el-table-column>
      </el-table>
    </el-card>
  </div>
</template>

<script>
  export default {
    name: "checkNotice",
    data() {
      return {
        table: [{
          cityCode: '123',
          productCode: '123',
          businessTypeCode: '312',
          business_record_date: '312',
          businessFee: '123',
          recordOperator: '123',
          checkStatus: 'dfs',
          checkPerson: 'fds',
          checkTime: 'fds'
        }]
      }
    },
    methods: {
      pass() {

      },
      reject() {

      }
    }
  }
</script>

<style lang="scss" scoped>
  .wrapper {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    height: 100%;
    width: 100%;

    .operations {
      height: 60px;
      position: relative;
      line-height: 60px;
      margin-top: -10px;
      width: 100%;


      .el-breadcrumb {
        display: inline-block;
        position: absolute;
        line-height: 60px;
        left: 0;
      }

      .el-button {
        display: inline-block;
        position: absolute;
        margin-top: 10px;
        right: 0;
      }
    }

    .el-card {
      flex: 15;
      flex-direction: column;
      height: 90%;
      width: 100%;


      .el-table {
        height: 100%;
      }


    }
  }


</style>
