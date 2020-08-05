import XLSX from "xlsx";

export default {
  exportXLS: function (xlsxName, tableData) {
    //  导出为xls
    var data = tableData
    // const header = {header: ['序号','城市','产品','出账类型','录入月份','录入金额','录入人'] }
    // 空表头参数则直接使用默认Json的表头，声明只能对应
    const header = {header: []}
    const ws = XLSX.utils.json_to_sheet(data, header)
    const wb = XLSX.utils.book_new()
    XLSX.utils.book_append_sheet(wb, ws, xlsxName)
    XLSX.writeFile(wb, xlsxName + ".xlsx")
  },
  getNowTime: function () {
    var nowDate = new Date()
    var dateTime = nowDate.getFullYear() + '-' + this.PrefixInteger(nowDate.getMonth(), 2)
      + '-' + this.PrefixInteger(nowDate.getDay(), 2) + ' '
      + this.PrefixInteger(nowDate.getHours(), 2) + ':' + this.PrefixInteger(nowDate.getHours(), 2)
      + ':' + nowDate.getSeconds()
    return dateTime
  },
  PrefixInteger: function (num, m) {
    return (Array(m).join(0) + num).slice(-m);
  }
}
