package io.mycat.eye.web.service;

import io.mycat.eye.web.dto.MyCnfGenerateSettingsDto;

public interface MySqlMyCnfGenerateService {

  String generate(MyCnfGenerateSettingsDto settingsDto);
}
