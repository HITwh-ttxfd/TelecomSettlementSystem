<template>
  <div class="wrapper">
    <div class="operations">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item :to="{ path: '/center' }">首页</el-breadcrumb-item>
        <el-breadcrumb-item>数据归集</el-breadcrumb-item>
        <el-breadcrumb-item>预转存收入</el-breadcrumb-item>
      </el-breadcrumb>
      <el-button size="small" type="primary" @click="exportTable">导出</el-button>
    </div>
    <el-card shadow="always">
      <el-table :data="table" id="table5" v-loading="loading">
        <el-table-column
          align="center"
          label="城市编码"
          prop="cityCode">
        </el-table-column>
        <el-table-column
          align="center"
          label="产品编码"
          prop="productCode">
        </el-table-column>
        <el-table-column
          align="center"
          label="销账日期"
          prop="recordDate">
        </el-table-column>
        <el-table-column
          align="center"
          label="销账类型编码"
          prop="writeOffTypeCode">
        </el-table-column>
        <el-table-column
          align="center"
          label="销帐金额"
          prop="writeOffFee">
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
      </el-table>
    </el-card>
  </div>
</template>

<script>
  import FileSaver from "file-saver";
  import XLSX from "xlsx";

  export default {
    name: "manageTransfers",
    data() {
      return {
        loading: false,
        table: []
      }
    },
    methods: {
      load() {
        this.loading = true;
        this.$axios({
          method: 'GET',
          url: 'http://localhost:8080/RpPreFeeRecordT/selectAllRpPreFeeRecordT',
        }).then(res => {
          this.table = res.data.map(item => {
            item.cityCode = item.rpCityCodeT.cityName;
            item.recordDate = new Date(item.recordDate).toLocaleDateString();
            item.writeOffTypeCode = item.rpWriteOffTypeCodeT.writeOffTypeName;
            item.productCode = item.rpProductCodeT.productName;
            return item;
          });
          this.loading = false;
        }).catch(e => {
          this.$message.error('无法连接到服务器');
        })
      },
      exportTable() {
        /* 从表生成工作簿对象 */
        var wb = XLSX.utils.table_to_book(document.querySelector("#table5"));
        /* 获取二进制字符串作为输出 */
        var wbout = XLSX.write(wb, {
          bookType: "xlsx",
          bookSST: true,
          type: "array"
        });
        try {
          FileSaver.saveAs(
            //Blob 对象表示一个不可变、原始数据的类文件对象。
            //Blob 表示的不一定是JavaScript原生格式的数据。
            //File 接口基于Blob，继承了 blob 的功能并将其扩展使其支持用户系统上的文件。
            //返回一个新创建的 Blob 对象，其内容由参数中给定的数组串联组成。
            new Blob([wbout], {type: "application/octet-stream"}),
            //设置导出文件名称
            "预转存收入.xlsx"
          );
        } catch (e) {
          if (typeof console !== "undefined") console.log(e, wbout);
        }
        return wbout;
      }
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


      .el-table {
        height: 100%;
      }


    }
  }
</style>
