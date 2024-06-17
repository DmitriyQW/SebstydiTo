package com.sebstydi.sebstydi.domain.models.resume

import com.sebstydi.sebstydi.domain.models.resume.values.AboutMe
import com.sebstydi.sebstydi.domain.models.resume.values.AboutProjects
import com.sebstydi.sebstydi.domain.models.resume.values.Directions
import com.sebstydi.sebstydi.domain.models.resume.values.Education
import com.sebstydi.sebstydi.domain.models.resume.values.FirstName
import com.sebstydi.sebstydi.domain.models.resume.values.LastName
import com.sebstydi.sebstydi.domain.models.resume.values.MidleName
import com.sebstydi.sebstydi.domain.models.resume.values.PhoneNumber
import com.sebstydi.sebstydi.domain.models.resume.values.Photo
import com.sebstydi.sebstydi.domain.models.resume.values.Portfolio
import com.sebstydi.sebstydi.domain.models.resume.values.Skills

data class Resume(var photo:Photo,
                  var lastName: LastName,
                  var firstName:FirstName,
                  var midleName:MidleName?=null,
                  var phoneNumber:PhoneNumber,
                  var education:Education,
                  var aboutMe:AboutMe? = null,
                  var direction:Directions,
                  var aboutProjects:AboutProjects? = null,
                  var skills:Skills,
                  var portfolio:Portfolio? = null)







