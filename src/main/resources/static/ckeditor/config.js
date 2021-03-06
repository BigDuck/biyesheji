/**
 * @license Copyright (c) 2003-2015, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see LICENSE.md or http://ckeditor.com/license
 */

CKEDITOR.editorConfig = function( config ) {
	// Define changes to default configuration here. For example:
	// config.language = 'fr';
	// config.uiColor = '#AADC6E';wo
	config.image_previewText=' '; //预览区域显示内容
	//TODO 修改上传请求
	config.filebrowserUploadUrl = '/uploads/upload?type=Files';//上传文件的保存路径
	config.filebrowserImageUploadUrl = '/uploads/upload?type=Images';//上传图片的保存路径
	config.filebrowserFlashUploadUrl = '/uploads/upload?type=Flash';//上传flash的保存路径
	// 图片浏览配置  
    config.filebrowserImageBrowseUrl = 'browerServer?type=image';
};
