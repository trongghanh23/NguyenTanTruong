use project_smartphone;
select smartphone.price,
specifications.front_camera,specifications.rear_camera,specifications.screen,
specifications.`storage`,specifications.processor_chip,smartphone_type.name,smartphone_type.image
from smartphone
join specifications on smartphone.specifications_id=specifications.id
join smartphone_type on smartphone.type_smartphone_id=smartphone_type.id
where smartphone_type.name like '%%';



