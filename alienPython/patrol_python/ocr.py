import sys
try:
    import cv2
    import pytesseract
    import numpy
    from imutils.perspective import four_point_transform
    from PIL import Image
    from PIL.ExifTags import TAGS
    photo = 'D:\\kmj\\javaProj\\alienProtector\\src\\main\\webapp\\img\\104.jpg'

    img = Image.open('D:\\kmj\\javaProj\\alienProtector\\src\\main\\webapp\\img\\104.jpg')
    time = ''
    info = img.getexif()
    for tag_id in info:
        tag = TAGS.get(tag_id, tag_id)
        data = info.get(tag_id)
        if tag == 'DateTime' or tag == 'DateTimeOriginal':
            time = f'{tag},{data}'
    img.close()
    print(time)
    ori = cv2.imread(photo)
    blur = cv2.GaussianBlur(ori,(7,7),0)
    edged = cv2.Canny(blur,0,255)
    pts, hh = cv2.findContours(edged, cv2.RETR_EXTERNAL, cv2.CHAIN_APPROX_SIMPLE)
    pts = sorted(pts, key=cv2.contourArea, reverse=True)

    recPP = None
    for pp in pts:
        approx = cv2.approxPolyDP(pp, cv2.arcLength(pp, True) * 0.02, True)
        if len(approx) == 4:
            recPP = approx
            break
    recArr = recPP.reshape(4, 2)
    recImg = four_point_transform(ori, recArr)

    ## 자른 이미지 글 인식
    samll = cv2.resize(recImg,(600, 300),interpolation=cv2.INTER_LANCZOS4)
    blur = cv2.GaussianBlur(samll, (7, 7), 0)
    edged = cv2.Canny(blur, 0, 255)

    ttt = pytesseract.image_to_string(edged,lang='kor+eng')
    print(ttt)
    # f = open('../text/aaa.txt', 'w', encoding='utf-8')
    # f.writelines(ttt)
    # f.close()
    # #
    cv2.imshow('bi',edged)
    cv2.waitKey()

except Exception as e:
    print(e)