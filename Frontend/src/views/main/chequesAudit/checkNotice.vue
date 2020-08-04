<template>
  <div class="wrapper">
    <div class="operations">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item :to="{ path: '/center' }">首页</el-breadcrumb-item>
        <el-breadcrumb-item>收款稽核</el-breadcrumb-item>
        <el-breadcrumb-item>通知单收入</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <el-card shadow="always" v-loading="loading">
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
          prop="businessRecordDate">
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
        <el-table-column align="center" label="稽核状态" width="150px">
          <template slot-scope="scope">
            <div v-if="!scope.row.checkStatus">
              <el-button
                size="mini"
                type="success"
                @click="edit(scope.$index, scope.row,'已通过')">通过
              </el-button>
              <el-button
                size="mini"
                type="danger"
                @click="edit(scope.$index, scope.row,'已拒绝')">拒绝
              </el-button>
            </div>
            <span v-else
                  :class="{'status':true,'passed':scope.row.checkStatus!=='已拒绝','rejected':scope.row.checkStatus==='已拒绝'}">
              {{scope.row.checkStatus}}
            </span>
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
        loading: true,
        table: []
      }
    },
    methods: {
      load() {
        this.loading = true;
        this.$axios({
          method: 'GET',
          url: 'http://localhost:8080/RpBusinessFeeRecordT/selectAllRpBusinessFeeRecordT',
        }).then(res => {
          this.table = res.data.map(item => {
            if (item.checkStatus === '未稽核')
              item.checkStatus = null;
            item.cityCode = item.rpCityCodeT.cityName;
            item.businessRecordDate = new Date(item.businessRecordDate).toLocaleDateString();
            item.businessTypeCode = item.rpBusinessFeeTypeCodeT.businessFeeTypeName;
            item.productCode = item.rpProductCodeT.productName;
            return item;
          });
          this.loading = false;
        }).catch(e => {
          this.$message.error('无法连接到服务器');
        })
      },
      edit(index, row, status) {
        this.$axios({
          method: 'GET',
          url: 'http://localhost:8080/RpBusinessFeeRecordT/updateRpBusinessFeeRecordT',
          params: {
            ID: row.id,
            checkStatus: status
          }
        }).then(res => {
          this.$message.success('修改成功');
          this.load();
        }).catch(e => {
          this.$message.error('修改失败');
        })
      },
    },
    beforeMount() {
      this.load();
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
      overflow: scroll;


      .el-table {
        height: 100%;

        .status {
          margin: 0;
        }

        .passed {
          color: #67c23a;
        }

        .rejected {
          color: #f46c6c;
        }
      }


    }
  }


</style>
