// /**
//  * Created by fenghao1 on 2017/6/8.
//  */
// // 默认配置
$.jgrid.defaults.jsonReader = {
    root: "list",
    page: "pageNum",
    total: "totalPages",
    records: "totalElements"
};
$.jgrid.defaults.prmNames = {
    page: "pageNum",
    rows: "pageSize"
};
$.jgrid.defaults.styleUI = 'Bootstrap';
// autowidth: true, shrinkToFit: false这样表格过宽时会有滚动条
$.jgrid.defaults.autowidth = true;
$.jgrid.defaults.shrinkToFit = false;
$.jgrid.defaults.height = 430;
$.jgrid.defaults.responsive = true;
//
// /*
// $.jgrid.defaults.styleUI = 'Bootstrap';
//
// $.jgrid.defaults.datatype = 'json';
// // 加载速度快，代价是无法用treeGrid, subGrid, afterInsertRow 事件
// $.jgrid.defaults.gridview = true;
// $.jgrid.defaults.rownumbers = true;
// $.jgrid.defaults.viewrecords = true;
// // autowidth: true, shrinkToFit: false这样表格过宽时会有滚动条
// $.jgrid.defaults.autowidth = true;
// $.jgrid.defaults.shrinkToFit = false;
// // 禁用所有列的排序
// $.jgrid.defaults.cmTemplate = { sortable: false };
// $.jgrid.defaults.height = 430;
// $.jgrid.defaults.rowNum = 10;
// $.jgrid.defaults.rowList = [10,20,30,50,100,200];
//
//
// /!**
//  * 表格底部显现操作按钮，默认显示编辑、添加、刷新、查看, 点击编辑、添加、查下等操作按钮会弹出对话框.
//  *
//  * 新增记录和编辑记录应返回json
//  * {
//  *    code : xxx,
//  *    msg: xxx
//  * }
//  * code 为200时表示成功
//  *
//  * @param $grid 表格jQuery对象
//  * @param gridPagerSelector 分页选择器
//  * @param options buttonOpts可以配置哪些按钮可见, dateSelector为需要显示日期选择控件的输入框选择器, disabledColSelector为编辑状态时需要禁用的输入框
//  *!/
// function navGrid($grid, gridPagerSelector, options) {
//     var opt = $.extend(true, {}, {buttonOpts:{edit: true, add: true, del: false, search: false, refresh: true, view: true, position: "left", cloneToTop: false }}, options);
//     var dateSelector = opt.dateSelector;
//     var disabledColSelector = opt.disabledColSelector;
//     $grid.navGrid(gridPagerSelector,
//         // the buttons to appear on the toolbar of the grid
//         opt.buttonOpts,
//         // options for the Edit Dialog
//         {
//             width: '85%',
//             editCaption: opt.editCaption || '编辑记录',
//             recreateForm: true,
//             reloadAfterSubmit : true,	// reload table data after submitting
//             checkOnUpdate : true,
//             checkOnSubmit : true,
//             closeAfterEdit: true,
//             errorTextFormat: function (data) {
//                 return 'Error: ' + data.responseText
//             },
//             beforeShowForm : function(e, action) {
//                 customDatePiker(e[0], dateSelector);
//                 disabledFormField(e[0], disabledColSelector, true);
//                 if (opt.beforeShowForm) {
//                     opt.beforeShowForm(e, action)
//                 }
//             },
//             afterSubmit: function (response, postData) {
//                 return handleResponse(response, postData);
//             }
//         },
//         // options for the Add Dialog
//         {
//             width: '85%',
//             addCaption: opt.addCaption || '增加记录',
//             recreateForm: true,
//             reloadAfterSubmit : true,	// reload table data after submitting
//             checkOnSubmit : true,
//             closeAfterAdd: true,
//             serializeEditData: function (data) {
//                 // 默认id是'_empty' java 类型中是long类型，设置成null
//                 if(data.id == "_empty") {
//                     data.id = null;
//                 }
//                 return data;
//             },
//             errorTextFormat: function (data) {
//                 return 'Error: ' + data.responseText
//             },
//             beforeShowForm : function(e) {
//                 customDatePiker(e[0], dateSelector);
//                 disabledFormField(e[0], disabledColSelector, false);
//                 if (opt.beforeShowForm) {
//                     opt.beforeShowForm(e, action)
//                 }
//             },
//             afterSubmit: function (response, postData) {
//                 return handleResponse(response, postData);
//             }
//         });
// }
//
// /!**
//  * 处理ajax返回的报文.
//  *
//  * @param response
//  * @param postData
//  * @returns {[boolean,*]}
//  *!/
// function handleResponse(response, postData) {
//     if (response.status == 200) {
//         var result = jQuery.parseJSON(response.responseText);
//         if(result.code == 200){
//             return [true, result.msg];
//         } else {
//             return [false, result.msg];
//         }
//     } else {
//         return [false, '网络开小差了. ' + response.status + ":" + response.statusText];
//     }
// }
//
// /!**
//  * 表格底部显现操作按钮，默认显示编辑、添加， 点击时进行行编辑
//  *
//  * 新增记录和编辑记录应返回json
//  * {
//  *    code : xxx,
//  *    msg: xxx
//  * }
//  * code 为200时表示成功
//  *
//  * @param $grid 表格jQuery对象
//  * @param gridPagerSelector 分页选择器
//  * @param options disabledColNames为编辑状态时需要禁用的输入框
//  *!/
// function inlineNav($grid, gridPagerSelector, options) {
//     var opt = $.extend(true, {}, {
//         edit: true,
//         add: true,
//         del: false,
//         cancel: true,
//         editParams: {
//             keys: true,
//             successfunc: function (jqXHR) {
//                 var result = handleResponse(jqXHR);
//                 alert(result[1]);
//                 return result[0];
//             },
//             aftersavefunc: function () {
//                 $grid.trigger('reloadGrid');
//             },
//             beforeEditRow: function (option, rowid) {
//                 if(options && options.disabledColNames) {
//                     for (var i = 0; i < options.disabledColNames.length; i++) {
//                         $grid.jqGrid("setColProp", options.disabledColNames[i], {editoptions: {disabled: true}});
//                     }
//                 }
//             }
//         },
//         addParams: {
//             keys: true,
//             rowID: 0,
//             addRowParams: {
//                 successfunc: function (jqXHR) {
//                     var result = handleResponse(jqXHR);
//                     alert(result[1]);
//                     return result[0];
//                 },
//                 aftersavefunc: function () {
//                     $grid.trigger('reloadGrid');
//                 }
//             },
//             beforeAddRow: function (option, rowid) {
//                 if(options && options.disabledColNames) {
//                     for (var i = 0; i < options.disabledColNames.length; i++) {
//                         $grid.jqGrid("setColProp", options.disabledColNames[i], {editoptions: {disabled: false}});
//                     }
//                 }
//             }
//         }
//     }, options);
//     $grid.inlineNav(gridPagerSelector,
//         // the buttons to appear on the toolbar of the grid
//         opt
//     );
// }
//
// /!**
//  * 底部添加添加、编辑按钮、点击按钮在新页面打开
//  * @param $grid 表格jQuery对象
//  * @param gridPagerSelector 分页选择器
//  * @param options
//  *   {
//  *   baseUrl: '', // url的前置部分
//  *   buttonOpts: {edit: true, add: true}, // 配置是否显示按钮
//  *   editUrl: 'edit',  // 编辑页面地址，相对于baseUrl
//  *   editParams: [], // 编辑页面所需参数 rowObject的字段名称数组
//  *   addUrl: 'add' // 添加页面地址，相对于baseUrl
//  *   }
//  *!/
// function actionLinkNav($grid, gridPagerSelector, options) {
//     var op = {buttonOpts: {edit: true, add: true}, editUrl: 'edit', editParams: [], addUrl: 'add'};
//     if(options !== undefined) {
//         op = $.extend(true, {}, op, options);
//     }
//
//     var url = '';
//     if(op.baseUrl !== undefined){
//         url = op.baseUrl;
//     }
//
//     $grid.navSeparatorAdd(gridPagerSelector);
//
//     if(op.buttonOpts.add == true && op.addUrl !== null) {
//         navButtonAdd($grid, gridPagerSelector, {
//             caption: '添加',
//             title: '打开新页面添加',
//             buttonicon: "",
//             onClickButton: function(){
//                 locationToUrl(url + op.addUrl);
//             }
//         });
//     }
//     if(op.buttonOpts.edit == true && op.editUrl !== null) {
//         navButtonAdd($grid, gridPagerSelector, {
//             caption: '编辑',
//             title: '在新页面编辑',
//             buttonicon: "",
//             onClickButton: function(){
//                 var rowObject = selectedRowObj($grid);
//                 if(rowObject) {
//                     var params = '';
//                     for(var i = 0; i < op.editParams.length; i++) {
//                         if(op.editParams[i] && rowObject[op.editParams[i]]) {
//                             params += '&' + op.editParams[i] + '=' + rowObject[op.editParams[i]];
//                         }
//                     }
//                     if(rowObject.id) {
//                         locationToUrl(url + op.editUrl + '?id=' + rowObject.id + params);
//                     } else {
//                         locationToUrl(url + op.editUrl + '?id=' + params);
//                     }
//                 }
//             }
//         });
//     }
// }
//
// /!**
//  * 获取选择的行对象
//  *
//  * @param $grid 表格jQuery对象
//  * @returns {*}
//  *!/
// function selectedRowObj($grid) {
//     var rowId = $grid.jqGrid('getGridParam', 'selrow');
//     if(rowId) {
//         var rowObj = $grid.getRowData(rowId);
//         return rowObj;
//     } else {
//         infoDialog('请先选择一行');
//         return null;
//     }
// }
//
// /!**
//  * 获取选择的若干行
//  * @param $grid
//  * @returns {Array}
//  *!/
// function selectedRowObjArray($grid) {
//     var rowIds = $grid.jqGrid('getGridParam', 'selarrrow'), rows = [];
//     if(rowIds && rowIds.length) {
//         for (var i = 0; i < rowIds.length; i++) {
//             var rowObj = $grid.getRowData(rowIds[i]);
//             rows.push(rowObj);
//         }
//         return rows;
//     } else {
//         infoDialog('请先选择');
//         return rows;
//     }
// }
//
// function setGridSelection($grid, id, status) {
//     $grid.jqGrid('setSelection', id, status);
// }
// /!**
//  * 获取页码和行数
//  * @param $grid
//  * @returns {{page: (*|number), rows: (*|number)}}
//  *!/
// function getJqGridPageAndRows($grid) {
//     var page = $grid.getGridParam('page') || 1;
//     var rows = $grid.getGridParam('rowNum') || 20;
//     var records = $grid.getGridParam('records') || 0;
//     rows = +rows;
//     return {
//         page: page,
//         rows: rows,
//         records: records
//     }
// }
//
// /!**
//  * 底部导航栏添加按钮
//  *
//  * @param $grid 表格jQuery对象
//  * @param gridPagerSelector 分页选择器
//  * @param options
//  *!/
// function navButtonAdd($grid, gridPagerSelector, options) {
//     $grid.navButtonAdd(gridPagerSelector, options);
// }
//
// /!**
//  * 重新加载表格.
//  *
//  * @param $grid 表格jQuery对象
//  * @param data 提交的参数对象
//  *!/
// function reloadGrid($grid, data, firstPage) {
//     var postData = $grid.jqGrid("getGridParam", "postData");
//     $.extend(postData, data);
//     if (firstPage) {
//         $grid.jqGrid("setGridParam", {search: true}).trigger("reloadGrid",[{page:1,current:true}]);
//     } else {
//         $grid.jqGrid("setGridParam", {search: true}).trigger("reloadGrid",[{current:true}]);
//     }
// }
//
// /!**
//  * 配置日期选择控件 默认格式：2017-06-15 14:00:01
//  * @param form
//  * @param selector
//  *!/
// function customDatePiker(form, selector) {
//     // enable datepicker on selector field
//     if (selector) {
//         $(form).find(selector).datetimepicker({timeFormat: 'HH:mm:ss', dateFormat: "yy-mm-dd", showMillisec:false});
//     }
// }
//
// /!**
//  * 设置表单控件禁用状态
//  * @param form
//  * @param selector
//  * @param disabled
//  *!/
// function disabledFormField(form, selector, disabled) {
//     if (selector) {
//         $(form).find(selector).attr('disabled', disabled);
//     }
// }
//
// /!**
//  * 配置日期选择控件 默认格式：2017-06-15 14:00:01
//  *
//  * @param cellValue
//  * @param options
//  * @param cell
//  *!/
// function pickDate(cellValue, options, cell) {
//     setTimeout(function()   {
//         $(cell).find('input[type=text]').datetimepicker({timeFormat: 'HH:mm:ss', dateFormat: "yy-mm-dd", showMillisec:false});
//     }, 0);
// }
//
// /!**
//  * 添加行编辑按钮
//  * @param cellVal 单元格值
//  * @param opts
//  *   {
//  *   baseUrl: '', // url的前置部分
//  *   buttonOpts: {edit: true}, // 配置是否显示按钮
//  *   editUrl: 'edit',  // 编辑页面地址，相对于baseUrl
//  *   editParams: [] // 编辑页面所需参数 rowObject的字段名称数组
//  *   }
//  * @param rowObj 行对象
//  * @returns {string}
//  *!/
// function actionLink(cellVal, opts, rowObj) {
//     var op = {baseUrl: '', buttonOpts: {edit: true}, editUrl: 'edit', editParams: []};
//     if(opts.colModel !== undefined && opts.colModel.formatoptions !== undefined) {
//         op = $.extend(true, {}, op, opts.colModel.formatoptions);
//     }
//
//     var url = op.baseUrl + op.editUrl + '?id=' + rowObj.id;
//     for(var i = 0; i < op.editParams.length; i++) {
//         if(op.editParams[i] && rowObj[op.editParams[i]]) {
//             url += '&' + op.editParams[i] + '=' + rowObj[op.editParams[i]];
//         }
//     }
//
//     var result = '';
//     if(op.buttonOpts.edit == true && op.editUrl !== null) {
//         result = '<a href="' + adaptUrlPrefix() + url +  '" ><span class="glyphicon glyphicon-edit"></span></a>';
//     }
//
//     return result;
// }
//
// /!**
//  * 设置自带行编辑控件可以编辑状态
//  *
//  * @param $grid 表格jQuery对象
//  * @param options disabledColNames为编辑状态时需要禁用的输入框
//  *!/
// function inlineEditDisabledWhenEditing($grid, options) {
//     var orgRowActions = $.fn.fmatter.rowactions;
//     $.fn.fmatter.rowactions = function (act) {
//         var $tr = $(this).closest("tr.jqgrow"),
//             rid = $tr.attr("id"),
//             rowData = $grid.jqGrid("getRowData", rid),
//             isNonEditable = false,
//             result;
//
//         // we can test any condition and change
//         // editable property of any column
//         if (act === "edit") {
//             if(options.disabledColNames) {
//                 for (var i = 0; i < options.disabledColNames.length; i++) {
//                     $grid.jqGrid("setColProp", options.disabledColNames[i], {editoptions: {disabled: true}});
//                 }
//                 isNonEditable = true;
//             }
//         }
//         result = orgRowActions.call(this, act);
//         if (isNonEditable) {
//             // reset the setting to original state
//             for (var i = 0; i < options.disabledColNames.length; i++) {
//                 $grid.jqGrid("setColProp", options.disabledColNames[i], {editoptions: {disabled: false}});
//             }
//         }
//         return result;
//     }
// }
//
// /!**
//  * 弹出对话框
//  * @param content
//  * @param title
//  *!/
// function infoDialog(content, title) {
//     $.jgrid.info_dialog(title || '信息', content || '', '关闭', {
//         styleUI:'Bootstrap',
//         left: ($(window).width() - 290)/2,
//         modal: true,
//         align: 'center'
//     });
// }
//
// */
